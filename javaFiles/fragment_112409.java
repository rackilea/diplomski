@GET
        @Path("/")
        @Produces("text/html")
    public String getStatus(@Context HttpServletRequest request) {
    return "<html><head><script>put your java script code here...</script></head></html>"
}