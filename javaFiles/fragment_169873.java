@RequestMapping(value = "/idpSelection", method = RequestMethod.GET)
public String idpSelection(HttpServletRequest request, Model model) {  
   if (request.getAttribute("javax.servlet.forward.request_uri") == null) {
       // Deny access
   }
   ...
}