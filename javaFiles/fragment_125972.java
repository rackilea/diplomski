import javax.swing.*;

public class Singers {

  public static void main(String[] args) {

    String[] singer = new String[4];

    for (int i = 0; i < singer.length; i++) {
      singer[i] = JOptionPane.showInputDialog("How is your favourite artist called? :");
      if (singer[i].equals("Heino")) {
        System.exit(0);
      }
    }

    String output = "";
    for (String bestesinger : singer){
      output = output + bestesinger + " ";
    }
    JOptionPane.showMessageDialog(null, "The name of your favourite artists are: " + output);
  }
}