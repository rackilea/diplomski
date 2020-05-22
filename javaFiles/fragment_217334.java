public LoginAction {

    @Action(...)
    public String login () {
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        ActionContext.getContext().getSession().put("user", user);
        return "success";
    }
}