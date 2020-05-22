@RequestMapping(value = "/some-file.js")
public ResponseEntity<String> resourceBundles(
    HttpServletRequest request, 
    HttpServletResponse response, Locale locale) throws IOException {

    Date lmod = session.getAttribute("lmod");
    if( null == lmod ) {
        lmod = new Date();
        session.setAttribute("lmod", lmod);
    }

    responseHeaders.add("Last-Modified", lmod);

    String ifModifiedSince = request.getHeader("If-Modified-Since");
    if( null != ifModifiedSince ) { // You may want to compare lmod and ifModifiedSince here, too
        return new ResponseEntity( responseHeaders, HttpStatus.NOT_MODIFIED );
    }

    ... create first time response ...
}