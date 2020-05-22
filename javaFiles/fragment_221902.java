@Provider
    public class RequestContextFilter implements ContainerRequestFilter,ContainerResponseFilter {
        @EJB
        UserCont uCont;

        @Override
        public void filter(ContainerRequestContext requestContext) throws IOException {
                RequestContext.initialize();
                //Here your code for assign data
                //RequestContext.setAttribute("myAtribute", value);
                //In my case
                String tokenAuth = requestContext.getHeaderString("Authorization");
            Long u = null;
            try {
                u = Sessions.get(tokenAuth);
            } catch (Exception e) {
            }
            User user = null;
            if (u != null) {
                user = uCont.find(u);
                RequestContext.setAttribute("user", user);
            }
        }

        @Override
        public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
            RequestContext.cleanup();
        }
    }