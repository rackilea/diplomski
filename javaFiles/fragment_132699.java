import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.net.URL;
import javax.imageio.ImageIO;

public class FrameTest2 {

    public static void main(String[] args) throws Exception {
        final String s = "Catch Torchic";
        URL url = new URL("http://pscode.org/media/stromlo2.jpg");
        final Image image = ImageIO.read(url);

        //Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                new MainMenu(s, image);
            }

        });
    }
}

class MainMenu extends JFrame {

    JButton autoa, manualb, createc, exitd;

    public MainMenu(String s, Image image) {
        super(s);
        // do this after pack (if at all)
        //setSize(640,600);
        // do this after pack/setSize
        //setVisible(true);
        // don't do this in broken code
        //setResizable(false);
        // If you're going to spend space on GUI position..
        // setLocationRelativeTo(null);
        // ..do it like this.
        setLocationByPlatform(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        CustomPanel panel = new CustomPanel(image);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //panel.setMinimumSize(new Dimension(600,365));
        //panel.setPreferredSize(new Dimension(600,365));
        //panel.setMaximumSize(new Dimension(600,365));
        contentPane.add(panel);
        JPanel btnPanel = new JPanel();
        btnPanel.setBorder(new EmptyBorder(5,5,100,5));
        btnPanel.setLayout( new BoxLayout(btnPanel, BoxLayout.Y_AXIS));
        // not needed for an SSCCE
        //btnPanel.setBackground(new Color(247,247,111));
        autoa = new JButton("AutoPlay");
        autoa.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPanel.add(autoa);

        manualb = new JButton("Manual Play");
        manualb.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPanel.add(manualb);

        createc = new JButton("Create Maze");
        createc.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPanel.add(createc);

        exitd = new JButton("Exit");
        exitd.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPanel.add(exitd);

        // you already said that
        //btnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(btnPanel, BorderLayout.SOUTH);
        setContentPane(contentPane);

        ButtonHandler handler = new ButtonHandler(this);
        autoa.addActionListener(handler);
        manualb.addActionListener(handler);
        createc.addActionListener(handler);
        exitd.addActionListener(handler);

        // CAUSE THE COMPONENTS TO BE PROPERLY LAID OUT.
        pack();
        setSize(640,600);
        setVisible(true);
    }

}

class ButtonHandler implements ActionListener{
    MainMenu mm;

    public ButtonHandler(MainMenu mm){
        this.mm = mm;
    }

    public void actionPerformed(ActionEvent e){
        // for clarity, even single line statements 
        // in these should be enclosed in {}
        if(e.getSource() == mm.autoa)
            System.out.println("Clicked on Auto");
        else if(e.getSource() == mm.manualb)
            System.out.println("Clicked on Manual");
        else if(e.getSource() == mm.createc)
            System.out.println("Clicked on Create");
        else
            System.exit(0);
    }

}

class CustomPanel extends JPanel{

    Image pic;

    CustomPanel(Image pic) {
        this.pic = pic;
    }

    public void paintComponent (Graphics painter){
        // DO NOT TRY TO READ IMAGES IN PAINT!
        //Image pic = Toolkit.getDefaultToolkit().getImage("logo.png");
        if(pic != null) painter.drawImage(pic, 105, 30, this);
    }
}