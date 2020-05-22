import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardTest
{   
    private JFrame frame;
    public static final String CARD_LOGIN =  "Card Login"; 
    public static final String CARD_WELCOME = "Card Welcome";
    public static JPanel cards;
    public CardLogin cardLogin = null;

    public CardTest()
    {
        frame = new JFrame("Card LOGIN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        cards = new JPanel();
        cards.setLayout(new CardLayout(20, 20));

        cardLogin = new CardLogin(this);
        cards.add(cardLogin, CARD_LOGIN);       

        frame.getContentPane().add(cards);
        frame.pack();
        frame.setVisible(true);
    }

    public void swapView(String key) 
    {
        CardLayout cardLayout = (CardLayout) cards.getLayout();
        cardLayout.show(cards, key);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new CardTest();
            }
        });
    }
}

class CardLogin extends JPanel 
{ 
    private ActionListener action; 
    CardTest cardLayoutLoginTest;
    /*
     *  Made JTextField an instance variable so that
     * ActionListener can access it or you can make 
     * it final.
     */
    private JTextField tfUsername= null; 
    private String username = null;

    public CardLogin(CardTest cardLayoutLoginTest) 
    { 
        this.cardLayoutLoginTest = cardLayoutLoginTest;
        init(); 
    } 

    private void init() 
    { 

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lbUsername = new JLabel("Username: ");
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 1;
        panel.add(lbUsername, gc);

        tfUsername = new JTextField(20);
        gc.gridx = 1;
        gc.gridy = 0;
        gc.gridwidth = 2;
        panel.add(tfUsername, gc);

        JLabel lbPassword = new JLabel("Password: ");
        gc.gridx = 0;
        gc.gridy = 1;
        gc.gridwidth = 1;
        panel.add(lbPassword, gc);

        JPasswordField pfPassword = new JPasswordField(20);
        gc.gridx = 1;
        gc.gridy = 1;
        gc.gridwidth = 2;
        panel.add(pfPassword, gc);

        final JButton loginButton = new JButton("Login"); 

        action = new ActionListener() 
        { 
            public void actionPerformed(ActionEvent ae) 
            {

                    // Here need code to update text filed of welcome card
                /*
                 * Here we are first checking if there is any text inside
                 * the JTextField for USERNAME, if found we will send it to the
                 * next JPanel which will be serving as a new Card.
                 */ 
                if (tfUsername.getDocument().getLength() > 0)   
                {
                    username = tfUsername.getText();
                    CardWelcome cardWelcome = new CardWelcome(cardLayoutLoginTest.cardLogin);
                    CardTest.cards.add(cardWelcome, cardLayoutLoginTest.CARD_WELCOME);
                    cardLayoutLoginTest.swapView(cardLayoutLoginTest.CARD_WELCOME);
                }
            } 
        }; 

        loginButton.addActionListener(action); 

        JPanel bp = new JPanel();
        bp.add(loginButton);

        /*set size of the frame*/
        setSize( 640, 480);

        add(panel, BorderLayout.CENTER);
        add(bp, BorderLayout.PAGE_END);

    } 

    public String getUserName()
    {
        return username;
    }
} 

class CardWelcome extends JPanel 
{ 
    private JTextField textField;
    private CardLogin cardLogin;

    public CardWelcome(CardLogin cl) 
    { 
        cardLogin = cl;
        init(); 
    } 

    private void init() 
    { 
        setLayout(new GridLayout(1, 1)); 
        JLabel userLabel = new JLabel("Welcome "); 
        textField = new JTextField(); 
        textField.setText(cardLogin.getUserName());
        System.out.println("UserName : " + cardLogin.getUserName());

        add(userLabel); 
        add(textField); 
    } 
}