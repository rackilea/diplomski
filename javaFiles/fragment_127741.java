while(true) {
  if (token == 'l')
    User.login();
  else if (token == 'r')
    User.register();
  else if (token == 'g')
    User.guestLogin();
  else {
    sopln("Invalid Choice, please try again!");
    continue;
  }
  break;
}