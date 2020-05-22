@RequestMapping(value = "/path", method = RequestMethod.POST)
public String path(Principal principal, HttpServletRequest request) {
   // do ur thing
   // return username
   principal.getName();
   return "path";
}