public class LogResponseFilter implements ContainerResponseFilter  {
    public void filter(ContainerRequestContext inContext, ContainerResponseContext outContext) throws IOException{

        Object entity = outContext.getEntity();
        //log entity.toSgring()

        //You can use the output stream to write a custom message
        //OutputStream outputStream = outContext.getEntityStream();
    }
}