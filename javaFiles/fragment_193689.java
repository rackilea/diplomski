@RequestMapping(value = "${foo.controller.requestMappingUrl.login}",
                                 method = RequestMethod.POST)
public ResponseMessage<String> loginUser(
            @RequestParam("username") String username,
               HttpServletRequest httpServletRequest,
               HttpServletResponse httpServletResponse) {

       return fooService.login(username);
}