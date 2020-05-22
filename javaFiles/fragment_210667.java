@Component("apiActivityFilter")
public class ApiActivityFilter implements Filter {

    @Autowired
    ApiActivityManager apiActivityManager;

    @Override public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        MyRequestWrapper requestWrapper = new MyRequestWrapper((HttpServletRequest)request);
        MyResponseWrapper responseWrapper = new MyResponseWrapper((HttpServletResponse)response);
        InputStream inputStream = requestWrapper.getInputStream();
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        if (inputStream != null) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            char[] charBuffer = new char[128];
            int bytesRead = -1;
            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                stringBuilder.append(charBuffer, 0, bytesRead);
            }
        } else {
            stringBuilder.append("");
        }
        String requestText = stringBuilder.toString();
        log.info(requestText);

        chain.doFilter((ServletRequest)requestWrapper,(ServletResponse)responseWrapper);

        String responseText = new String(responseWrapper.getCopy(),responseWrapper.getCharacterEncoding());
        log.info(responseText);
        //for log details in database
        apiActivityManager.logApiActivity(activityLog);//activityLog Object to be logged
    }

    @Override public void destroy() {

    }
}