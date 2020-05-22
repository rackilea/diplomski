import javax.swing.JOptionPane;

public class ConfirmDialog
 {
    public static void main (String args []){


    int choose= JOptionPane.showConfirmDialog(null, "Open Dialog  ??");

    if(choose== JOptionPane.YES_OPTION) {
        JOptionPane.showMessageDialog(null,"You Clicked Yes !!");
    } else if(choose== JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null,"You Clicked NO");
    }
        }
         }