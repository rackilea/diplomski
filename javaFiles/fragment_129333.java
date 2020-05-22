import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class OpenImage extends JFrame implements ActionListener {

    private static final long serialVersionUID = 9066218264791891436L;
    private Image img;

    public OpenImage() {
        super("Resize and Rotate");

        JButton open = new JButton("Open");
        open.addActionListener(this);
        JButton rotate = new JButton("Rotate");
        rotate.addActionListener(this);
        JButton resize = new JButton("Resize");
        resize.addActionListener(this);
        JButton exit = new JButton("Exit");
        exit.addActionListener(this);

        JPanel row1 = new JPanel();
        row1.setBackground(Color.red);
        row1.setLayout(new FlowLayout());
        row1.setBorder(new LineBorder(Color.black, 1));
        row1.add(open);
        row1.add(rotate);
        row1.add(resize);
        row1.add(exit);

        JPanel imagepanel = new JPanel();
        imagepanel.setLayout(new BorderLayout());
        imagepanel.setBackground(Color.blue);
        imagepanel.setBorder(new LineBorder(Color.black, 1));
        imagepanel.setPreferredSize(new Dimension(600, 400));

        JPanel row2 = new JPanel();
        row2.setLayout(new BorderLayout(10, 10));
        row2.setBorder(new LineBorder(Color.black, 1));
        row2.add(imagepanel, BorderLayout.CENTER);
        row2.setBackground(Color.red);
        JButton save = new JButton("Save");

        JPanel row3 = new JPanel();
        row3.setBorder(new LineBorder(Color.black, 1));
        row3.setBackground(Color.green);
        row3.setLayout(new FlowLayout());
        row3.add(save);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        add(BorderLayout.NORTH, row1);
        add(BorderLayout.CENTER, row2);
        add(BorderLayout.SOUTH, row3);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command == "Exit") {
            System.exit(0);
        }
        if (command == "Open") {
            JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showOpenDialog(this);
        }
    }

    public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                OpenImage openImage = new OpenImage();
            }
        });
    }
}