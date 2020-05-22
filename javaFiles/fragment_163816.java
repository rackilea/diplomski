public UserBean getUserBean() {
    if(!session.containsKey("userBean"))
        this.setUserBean(new UserBean());
    return (UserBean) session.get("userBean");
}

public void setUserBean(UserBean userBean) {
    session.put("userBean", userBean);
}