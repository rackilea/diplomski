import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginFrame
{
  // Hardcode user entered username and password to simplify the program
  String username = "hf45";
  String password = "1234";

  public static void main(String[] args)
  {
    new LoginFrame().verifyLogin();
  }

  public void verifyLogin()
  {
    try {
      File f = new File("UserDetails.txt");
      Scanner fileRead = new Scanner(f);

      boolean matched = false;
      while(fileRead.hasNextLine())
      {
        String textLine = fileRead.nextLine();
        String[] userDetails = textLine.split(" : ");
        String tempUsername = userDetails[3];
        String tempPassword = userDetails[4];

        if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim()))
        {
          matched = true;
          break;
        }
      }

      if (matched)
      {
        //new LibraryCatalogFrame().setVisible(true);
        System.out.println("Show JFrame");
      }
      else
      {
        System.out.println("Show dialog");
        //JOptionPanes.messageBox("Please re-enter your user details", "Incorrect Username or Password");
      }
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      //JOptionPanes.messageBox("Error", "FileNotFound");
    }
  }
}