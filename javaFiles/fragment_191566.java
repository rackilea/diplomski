@RequestMapping(value = "/show", method = RequestMethod.POST)
    public ModelAndView newUser(ModelMap model, Principal principal) {
        String userName=principal.getName(); // username or email using user login
        User user=userService.getUserByName(userName); // retrieve current user information
        UserInfo userinfo = new UserInfo();  // create userinfor object
        userinfo.setPlacesVisit(userinfo.getPlacesVisit());
            user.setUserInfo(userinfo);   // set userinfo to user
        userService.update(user);  // update user
         String message = "Userinfo was successfully added.";
             result.addObject("message", message);
        return result;

    }