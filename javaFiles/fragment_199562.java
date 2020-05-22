@ModelAttribute
    public void fillUsers(Model model) {
        model.addAttribute("USERS", userService.getUsers());
    }

    @ModelAttribute
    public void getUser(@RequestParam(required = false) String userName, Model model) {
        User user = null;
        if (userName != null) {
            user = userService.getUserByName(userName);
        }
        if (user == null) {
            user = new User();
        }
        model.addAttribute("user", user);
    }

    @RequestMapping("/toAddFriend")
    public String toAddNewFriend() {
        return "addFriend";

    }

    @RequestMapping(value = "/requestForFriends", method = RequestMethod.POST)
    public String requestNewFriend(@ModelAttribute("user") User user) {
        System.out.println(user.getUserName());
        System.out.println(user.getEmail());
        return "addFriend";

    }