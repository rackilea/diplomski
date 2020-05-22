package de.professional_webworkx.vlcj;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VideoFrame extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private VideoPanel videoPanel;

    public VideoFrame() {
        initializeGUI();
    }

    private void initializeGUI() {

        JPanel buttonPanel = createButtonPanel();

        this.setTitle("MyVideoApp");
        this.setSize(1024, 768);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        videoPanel = new VideoPanel("/home/ottp/Videos/Test.ogv");
        this.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        this.getContentPane().add(videoPanel, BorderLayout.CENTER);
        this.setVisible(true);
        videoPanel.startPlayer();
    }

    private JPanel createButtonPanel() {

        JPanel buttonPanel  = new JPanel(new GridLayout(1, 2));
        JButton nextVideo   = new JButton("Next Video");
        nextVideo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateVideoPanel();
            }


        });
        buttonPanel.add(nextVideo);
        JButton prevVideo   = new JButton("Prev Video");
        buttonPanel.add(prevVideo);
        return buttonPanel;
    }

    private void updateVideoPanel() {
        this.remove(videoPanel);
        videoPanel = new VideoPanel("/home/ottp/Videos/Example.ogv");
        this.getContentPane().add(videoPanel, BorderLayout.CENTER);
        videoPanel.startPlayer();
        revalidate();
    }

}