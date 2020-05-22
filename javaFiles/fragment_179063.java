Map<String, Object> sessionMap = externalContext.getSessionMap();
LoginBean loginBean = (LoginBean) sessionMap.get("loginBean");
if (loginBean == null) {
    loginBean = new LoginBean();
    sessionMap.put("loginBean", loginBean);
}
// ...