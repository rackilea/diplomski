public class KPFilter implements ContainerResponseFilter {

    private Logger LOG = LoggerFactory.getLogger(KPFilter.class);

    public void filter(ContainerRequestContext requestContext,
            ContainerResponseContext responseContext) throws IOException {

        if(responseContext.getStatus()== Status.OK.getStatusCode()){
            final String myHeader = requestContext.getHeaderString("myHeader");
            if(myHeader !=null && myHeader.equals("kp-header")){
                responseContext.getHeaders().add("resHeader", myHeader+"-res");
            }else{
                responseContext.setEntity("An erro occured");
                responseContext.setStatus(500);
            }
        }else{
            LOG.info("Status is not OK, its {}", responseContext.getStatus());
        }

    }
}