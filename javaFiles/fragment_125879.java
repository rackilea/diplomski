import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TrivialImageViewer implements Runnable {

    private static final Font DEMO_FONT = new Font("Arial", Font.BOLD, 20);

    private final JFrame frame;
    private final JFileChooser fileChooser;
    private final JLabel iconLabel;

    private final class SelectImageAction extends AbstractAction {
        private static final long serialVersionUID = 1L;

        private SelectImageAction(final String name) {
            super(name);
        }

        @Override
        public void actionPerformed(final ActionEvent e) {

            final int option = fileChooser.showOpenDialog(frame);
            if (option != JFileChooser.APPROVE_OPTION) {
                return;
            }

            final File selectedFile = fileChooser.getSelectedFile();

            URL url;
            try {
                url = selectedFile.toURI().toURL();
            } catch (final MalformedURLException e1) {
                throw new RuntimeException(e1);
            }

            final ImageIcon icon= new ImageIcon(url);
            iconLabel.setText("");
            iconLabel.setIcon(icon);
        }
    }

    public TrivialImageViewer() {
        frame = new JFrame();
        frame.setTitle("Trivial Swing ImageViewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        iconLabel = new JLabel("Please select an image.");
        iconLabel.setFont(DEMO_FONT);
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);

        fileChooser = new JFileChooser();

        frame.add(iconLabel, BorderLayout.CENTER);
        frame.add(new JButton(new SelectImageAction("Select Image...")), BorderLayout.SOUTH);
    }

    @Override
    public void run() {
        frame.setBounds(16, 16, 640, 480);
        frame.setVisible(true);
    }

    public static void main(final String[] args) throws Exception {
                    // Use EventQueue.invokeLater in serious apps...
        final TrivialImageViewer application = new TrivialImageViewer();
        application.run();
    }
}