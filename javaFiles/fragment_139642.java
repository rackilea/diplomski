import java.applet.Applet;
import java.awt.*;
import java.security.AccessControlException;

public class TestApp extends Applet {
  Label output = new Label("What is the value of user.name?");
  String userName;
  Thread access = new Thread() {
    @Override
    public void run() {
      try {
        userName = System.getProperty("user.name");
      } catch (AccessControlException e) {
        userName = "Oops, failed in thread. No read permissions!";
      }
    }
  };
  public void init() {
    setLayout(new BorderLayout());
    add(BorderLayout.CENTER, output);
  }
  public String userName2() throws InterruptedException {
    access.start();
    access.join();
    output.setText(userName);
    return userName;
  }
  public String userName() {
    String userName = "Oops, failed in liveconnect-context. No read permissions!";
    try {
      userName = System.getProperty("user.name");
    } catch (AccessControlException e) {
      e.printStackTrace();
    }
    output.setText(userName);
    return userName;
  }
}