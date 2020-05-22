public class SwitCase {
    public static void main (String[] args){
        String hello = JOptionPane.showInputDialog("Input a letter: ");
        char hi = hello.charAt(0); //get the first char.
        switch(hi){
            case 'a': System.out.println("a");
        }
    }   
}