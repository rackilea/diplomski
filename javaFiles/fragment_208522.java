RequestMapping(value = "/userformat", method = RequestMethod.GET)
public @ResponseBody User getUserFormat() {
    User user = new User();
    user.setUserId(0);
    user.setFirstName("dfsdfsd");
    user.setUserMailId("sadsda");
    user.setAddress("sfds");
    user.setCreatedBy(1);
    user.setIsDeleted(0);
    user.setLastName("sadas");
    user.setMobileNumber("adsasdsa");
    user.setUsrtStatus(1);
    user.setUserPassword("asdsaf");
    user.setRoleId(1);

    return user;
}