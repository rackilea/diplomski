@Provider
public class ResponseCorsFilter implements ContainerResponseFilter{

    @Override
    public void filter(ContainerRequestContext requestContext,
            ContainerResponseContext responseContext) throws IOException {
           responseContext.getHeaders()
                .putSingle("Access-Control-Allow-Origin","*");
           responseContext.getHeaders()
                 .putSingle("Access-Control-Allow-Methods",
                     "GET, POST, PUT, DELETE");
           List<String> reqHead=requestContext.getHeaders()
                     .get("Access-Control-Request-Headers");
           if(null != reqHead){
                responseContext.getHeaders()
                   .put("Access-Control-Allow-Headers", 
                        new ArrayList<Object>(reqHead));
           }
    }

}