// use an appropriate method to find the number of letters
if(userName.length() == secondName.length()) {
  System.out.printf("%s (%d characters long) is equal in length than %s (%d characters long)\n", userName, userName.length(), secondName, secondName.length());
} else if(userName.length() > secondName.length()) {
  System.out.printf("%s (%d characters long) is longer in length than %s (%d characters long)\n", userName, userName.length(), secondName, secondName.length());
} else {
  System.out.printf("%s (%d characters long) is shorter in length than %s (%d characters long)\n", userName, userName.length(), secondName, secondName.length());
}