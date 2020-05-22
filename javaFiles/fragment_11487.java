public class MainMenuofgame extends JFrame implements ActionListener{
    JButton slow, medium, fast;
    JLabel pic1, pic2, pic3, pic4;
    JTextField username;
    Container frame;

    static String name;
    static int xspeed = 0;          

    public MainMenuofgame() { 
            super ("Main Menu of Rocket Launch");
            frame = getContentPane ();
            frame.setLayout (null);

            pic1 = new JLabel (new ImageIcon ("welcome.png"));

            pic2  = new JLabel (new ImageIcon ("name.png"));

            pic3 = new JLabel (new ImageIcon ("speed.png"));

            pic4 = new JLabel (new ImageIcon ("backgnd.jpg"));

            username = new JTextField ();

            slow = new JButton("Slow");
            //  slow.setActionCommand("slowspeed");
            slow.addActionListener (this);

            medium = new JButton("Medium");
            // medium.setActionCommand("mediumspeed");
            medium.addActionListener (this);

            fast = new JButton("Fast");
            // fast.setActionCommand("fastspeed");
            fast.addActionListener (this);

            pic1.setBounds (30,50, 525, 173);//welcome
            pic2.setBounds (100,230,212,73);//name
            pic3.setBounds (80,350,428,84);//speed

            username.setBounds(310,255,150,30);

            slow.setBounds (100,450,100,100);
            medium.setBounds (250,450,100,100);
            fast.setBounds (400,450,100,100);
            //background bound goes in the end 
            pic4.setBounds (0,0, 600,900);

            frame.add (pic1);

            frame.add (pic2);

            frame.add (pic3);

            frame.add (username);

            frame.add (slow);

            frame.add (medium);

            frame.add (fast);    

            frame.add (pic4);


            setSize(600, 900);
            setVisible (true);
            setDefaultCloseOperation (EXIT_ON_CLOSE);

    }

    public void actionPerformed (ActionEvent evt){

            String name = username.getText();
            Rocketlaunch.name = name;

            if (evt.getSource () == slow)
            {
                    Rocketlaunch.moveSpeed = 1;
                    Rocketlaunch.speed = "Slow";
                    setVisible (false);
            }
            else if(evt.getSource () == medium)
            {
                    Rocketlaunch.moveSpeed = 5;
                    Rocketlaunch.speed = "Medium";
                    setVisible (false);
            }
            else 
            {
                    Rocketlaunch.moveSpeed = 10;
                    Rocketlaunch.speed = "Fast";
                    setVisible (false);
            }

            new Rocketlaunch();

    }



    public static void main(String[] args) { 
            new MainMenuofgame ();
    }

}