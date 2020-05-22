import java.io.*;
import javax.swing.*;
import java.net.*;

public class exmpleText
{

  public static void main(String[] args)
  {
    String url = "C:\\Users\\welcome\\z.txt";
    File f = new File(url);

    try
    {
      URL x = f.toURL();
      System.out.println(x);         

      JFrame frame=new JFrame("Hi");

      JEditorPane Pane = new JEditorPane(x);
      Pane.setEditable(false);

      frame.add(new JScrollPane(Pane));
      frame.setVisible(true);
    } 
    catch(Exception ioe) 
    {
      System.out.println(ioe);
      System.err.println("Error displaying " + url);
    }
  }
}