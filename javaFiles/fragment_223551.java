import java.net.URL;
    import java.util.Scanner;

    import javax.swing.ImageIcon;
    import javax.swing.JFrame;
    import javax.swing.JLabel;

    public class OpenImage {

        private static final String IMG_FILE_PATH = "index.jpg";
        private static final String USERNAME = "Hudhud";
        private static final int PASSWORD = 123;

    public static void main(String[] args){
        String un;
        int pass;

        System.out.println("Welcome, please enter the username and password to open the image");
        Scanner scan = new Scanner(System.in);
        System.out.println("Username?:");
        un = scan.nextLine();
        System.out.println("Password?:");
        pass = scan.nextInt();

        if(un.equals(USERNAME) && pass==PASSWORD){
            System.out.println();
            System.out.println("Here you got the picture");
            URL url = OpenImage.class.getResource(IMG_FILE_PATH);
            ImageIcon icon = new ImageIcon(url);
            JFrame frame = new JFrame();
            frame.setSize(300, 300);
            JLabel label = new JLabel(icon);
            frame.add(label);
            frame.setVisible(true);
        }
        else{
            System.out.println("You ain't the boss");
        }
     }

    }