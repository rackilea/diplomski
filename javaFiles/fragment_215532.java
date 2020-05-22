package de.professional_webworkx.filechoosing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class MyFileChooser extends JFrame {

    private JFileChooser chooser;
    private JButton saveBtn;
    private MyFileChooser myFileChooser;
    public MyFileChooser() {

        myFileChooser = this;
        saveBtn = new JButton("Save");
        saveBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                chooser = new JFileChooser(System.getenv("user.home"));
                chooser.setSelectedFile(new File(<YOUR_STRING>));
                chooser.showSaveDialog(myFileChooser);
            }
        });
        this.getContentPane().add(saveBtn);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 480);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {

        new MyFileChooser();
    }
}