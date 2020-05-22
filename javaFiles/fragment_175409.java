@RequestMapping(method = RequestMethod.GET, value = "/exception2")
public String getException1(ModelMap model, @CRequestParam("p") String p, HttpServletRequest request) {

  System.out.println("Exception 2 " + p);
  request.setAttribute("p", p);
  throw new CustomGenericException("1", "2");
}