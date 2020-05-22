package com.example.UserAccount;

public class MyUI {
  public boolean checkUser(User user) {
    return user.getName().toUpperCase().contains("ADMIN");
  }

  public static void main(String[] args) {
    MyUI ui = new MyUI();
    System.out.println(ui.checkUser(new User("Administrator")));
    System.out.println(ui.checkUser(new User("john")));
    System.out.println(ui.checkUser(new User("xander")));
    System.out.println(ui.checkUser(new User("admiral")));
    System.out.println(ui.checkUser(new User("SySaDmiN")));
  }
}