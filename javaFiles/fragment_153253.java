@RequestMapping(value = "/users/remove", method = RequestMethod.POST, produces = "application/json")
@ResponseBody
public RestReponse removeUser(@RequestParam(value="userId") String userId, @RequestParam(value="userName") String userName, HttpServletRequest request, HttpServletResponse response) 
{
  ...

  if(responseMsg.equals("TRUE") || responseMsg.equals("DUPLICATE"))
  {
    return new RestReponse(true, userName + " was removed successfully.");
  }

  return new Response(false, "There was an error when removing " + userName);
}