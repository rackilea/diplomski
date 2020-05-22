@Component("authenticationFilter")
    public class RequestBodyReaderAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

        private static final Log LOG = LogFactory.getLog(RequestBodyReaderAuthenticationFilter.class);
        private static final String ERROR_MESSAGE = "Error en la validación con AD";
        private final ObjectMapper objectMapper = new ObjectMapper();
        public RequestBodyReaderAuthenticationFilter() {
        }

        @Autowired
        @Qualifier("authenticationManager")
        @Override
        public void setAuthenticationManager(AuthenticationManager authenticationManager) {
            super.setAuthenticationManager(authenticationManager);
        }

        @Override
        protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
            LOG.error("El usuario no existe en AD");
            response.sendRedirect(request.getContextPath()+"/login?error"); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
            String requestBody;
            Boolean valido = false;
            try {
                requestBody = IOUtils.toString(request.getReader());
                ArrayList<String> credenciales = new ArrayList<String>();
                //Busco el Usu y pass enviados en el request
                for (String val : requestBody.split("&")) {
                    credenciales.add(val.split("=")[1]);
                }

                try {
                    //hago el llamado el WS
                    org.tempuri.ADWS service = new org.tempuri.ADWS();
                    org.tempuri.IADWS port = service.getBasicHttpBindingIADWS();

                    valido = port.login(credenciales.get(0), credenciales.get(1));
                } catch (Exception ex) {
                    LOG.error(ERROR_MESSAGE, ex);
                }
                UsernamePasswordAuthenticationToken token;
                if (valido) {
                    //si existe en AD, realizo la validación en el sistema
                    token = new UsernamePasswordAuthenticationToken(credenciales.get(0), credenciales.get(1));
                    setDetails(request, token);
                    return this.getAuthenticationManager().authenticate(token);
                }else{
                    throw new InternalAuthenticationServiceException(ERROR_MESSAGE);                
                }
            } catch (IOException e) {
                LOG.error(ERROR_MESSAGE, e);
                throw new InternalAuthenticationServiceException(ERROR_MESSAGE, e);
            }
        }
    }