@RequestMapping(value = "/product/" , 
      method = RequestMethod.GET)
@ResponseBody
public String singleProduct(HttpServletRequest request)
{
    String name = request.getUserPrincipal().getName();
   return name;

}