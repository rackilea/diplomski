private static final String EMPLOYEE_ID = "employeeid";
private static final String FIRST_NAME = "firstname";
private static final String LAST_NAME = "lastName";
private static final String GENDER = "gender";
private static final String MOBILE_NO = "mobileno";
private static final String EMAIL_ID = "emailid";

Person p =new Person ();
for(String element: myList) {
switch (element.toLowerCase()) {
  case EMPLOYEE_ID: p.setemployeeID("");
    break;
  case FIRST_NAME: p.setfirstName("");
    break;
  case LAST_NAME: p.setlastName("");
    break;
  case GENDER: p.setgender("");
    break;
  case MOBILE_NO: p.setMobileNo("");
    break;
  case EMAIL_ID: p.setEmailID("");
    break;
}

}