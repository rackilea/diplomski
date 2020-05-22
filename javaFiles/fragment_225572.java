@Override
public void aroundWriteTo(WriterInterceptorContext writerInterceptorContext) throws IOException {
    OutputStream outputStream = writerInterceptorContext.getOutputStream();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    writerInterceptorContext.setOutputStream(baos);
    String clientId = writerInterceptorContext.getHeaders().getFirst("ClientId").toString();
    String user = writerInterceptorContext.getHeaders().getFirst("UserId").toString();   
}