@RequestMapping(value = "/first", method = RequestMethod.GET)
public ResponseEntity get(HttpServletRequest request)
{
    CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
    System.out.println(token.getHeaderName()+" = "+token.getToken());
    return ResponseEntity.ok("first");
}