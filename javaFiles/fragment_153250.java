@RequestMapping(value = "/users/remove", method = RequestMethod.POST, produces = "text/plain")
@ResponseBody
public String removeUser(@RequestParam(value="userId") String userId, @RequestParam(value="userName") String userName, HttpServletRequest request, HttpServletResponse response) 
{
  ...
}