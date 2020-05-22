import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.*;
import sun.awt.shell.ShellFolder;

public class ShowShellIcon {
    private static void createAndShowUI() {
        final JFrame frame = new JFrame("Load Image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton loadButton = new JButton("Display Image");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser(
                        System.getProperty("user.home"));
                if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                    try {
                        ShellFolder shell = ShellFolder.getShellFolder(fc
                                .getSelectedFile());
                        JOptionPane.showMessageDialog(null,
                                new ImageIcon(shell.getIcon(true)));
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        frame.add(loadButton);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                } 
                createAndShowUI();
            }
        });
    }
}