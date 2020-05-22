package Aspects;

import com.example.UserAccount.User;
import com.example.UserAccount.MyUI;

public aspect UserAccount {
  pointcut checkUser(User user) :
    execution(boolean MyUI.checkUser(*)) && args(user);

  boolean around(User user) : checkUser(user) {
    System.out.println(thisJoinPoint + " -> " + user);
    if (user.getName().equalsIgnoreCase("xander"))
      return true;
    return proceed(user);
  }
}