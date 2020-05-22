@RequestMapping(value = "/delete", method = RequestMethod.GET)
public String deleteUser(@RequestParam("login") String login,
        ModelMap map, HttpServletRequest request)
    map.put("message", "User deleted");
    String message = (String) request.getAttribute("message"); // will return null
    ...
}