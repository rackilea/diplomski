import com.jhlabs.image.GaussianFilter;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;
import org.jdesktop.jxlayer.JXLayer;
import org.jdesktop.jxlayer.plaf.AbstractLayerUI;

public class FormValidationExample {

    public static void main(String[] args) {
        new FormValidationExample();
    }

    public FormValidationExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JXLayer<JPanel> layer;

        private javax.swing.JComboBox cboOne;
        private javax.swing.JTextField txtOne;
        private javax.swing.JTextField txtTwo;

        private DefaultValidationHighlightModel validationModel;
        private boolean ignoreValidationRequest;

        public TestPane() {
            setLayout(new BorderLayout());
            JPanel content = new JPanel(new GridBagLayout());

            ValidationUI ui = new ValidationUI();
            validationModel = new DefaultValidationHighlightModel(ui);

            layer = new JXLayer<>(content, ui);
            add(layer);

            cboOne = new javax.swing.JComboBox();
            cboOne.setInputVerifier(new AbstractValidationInputVerifier(validationModel) {
                @Override
                public boolean verify(JComponent input) {
                    boolean valid = false;
                    JComboBox cb = (JComboBox) input;
                    String textOfOne = txtOne.getText();
                    String textOfTwo = txtTwo.getText();
                    if (cb.getSelectedIndex() == 2) {
                        valid = true;
                    } else if (cb.getSelectedIndex() == 0
                            && "123".equals(textOfOne)
                            && "456".equals(textOfTwo)) {
                        valid = true;
                    } else if (cb.getSelectedIndex() == 1
                            && "456".equals(textOfOne)
                            && "789".equals(textOfTwo)) {
                        valid = true;
                    }
                    return valid;
                }
            });
            txtOne = new javax.swing.JTextField("123", 10);
            txtOne.setInputVerifier(new AbstractValidationInputVerifier(validationModel) {
                @Override
                public boolean verify(JComponent input) {
                    JTextField field = (JTextField) input;
                    String text = field.getText();
                    return "123".equals(text) || "456".equals(text);
                }
            });
            txtTwo = new javax.swing.JTextField("123", 10);
            txtTwo.setInputVerifier(new AbstractValidationInputVerifier(validationModel) {
                @Override
                public boolean verify(JComponent input) {
                    JTextField field = (JTextField) input;
                    String text = field.getText();
                    return "456".equals(text) || "789".equals(text);
                }
            });

            cboOne.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Only works with 123, 456", "Only works with 456, 789", "Works with everybody"}));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(4, 4, 4, 4);

            content.add(cboOne, gbc);
            content.add(txtOne, gbc);
            content.add(txtTwo, gbc);

            validateFields();

        }

        protected void validateFields() {
            if (!ignoreValidationRequest) {
                ignoreValidationRequest = true;
                try {
                    cboOne.getInputVerifier().shouldYieldFocus(cboOne);
                    txtOne.getInputVerifier().shouldYieldFocus(txtOne);
                    txtTwo.getInputVerifier().shouldYieldFocus(txtTwo);
                } finally {
                    ignoreValidationRequest = false;
                }
            }
        }

        public abstract class AbstractValidationInputVerifier extends InputVerifier {

            private IValidationHighlightModel model;

            public AbstractValidationInputVerifier(IValidationHighlightModel model) {
                this.model = model;
            }

            public IValidationHighlightModel getModel() {
                return model;
            }

            @Override
            public boolean shouldYieldFocus(JComponent input) {
                if (verify(input)) {
                    getModel().removeInvalidField(input);
                } else {
                    getModel().addInvalidField(input);
                }
                validateFields();
                return true;
            }

        }

    }
}