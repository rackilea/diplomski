@RequestMapping(value = "/authentication/register", method = RequestMethod.POST)
public @ResponseBody Response register(@RequestBody String jsonRequest,
   HttpServletResponse response) {
  AuthenticationService authenticationService = new AuthenticationService();
  Response registerResponse =   authenticationService.registerUser(jsonRequest);
  return registerResponse;
}}