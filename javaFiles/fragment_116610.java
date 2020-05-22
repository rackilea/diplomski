public class MD5CheckFilter implements ContainerRequestFilter {

    @Context HttpServletRequest hsr;

    public ContainerRequest filter(ContainerRequest request) {

        byte[] bytes = request.getEntity(byte[].class); // this consumes the entity input stream
        String contentMD5 = calculateMD5(bytes);
        hsr.setAttribute("contentMD5", contentMD5);

        // set the entity input stream so it can be consumed again
        request.setEntityInputStream(new ByteArrayInputStream(bytes));

        return request;
    }

}