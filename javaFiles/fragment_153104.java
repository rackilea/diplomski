private static void verifyUser(String userName, String password) {
    //null check and all

    Map<String, String> login = new HashMap<String, String>();
    for (int i = 0; i < EMPLOYEE.length; i++) {
        login.put(EMPLOYEE[i], EMPLOYEE_PSWD[i]);
    }
    if (login != null && login.size() > 0 && password.equals(login.get(userName))) {
        System.out.println("Valid username and password");
    } else {
        System.out.println("Invalid password or username");
    }
}