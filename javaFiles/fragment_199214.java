import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jdesktop.jxlayer.JXLayer;
import org.pbjar.jxlayer.demo.TransformUtils;
import org.pbjar.jxlayer.plaf.ext.transform.DefaultTransformModel;

public class Twister02 {

    public static void main(String[] args) {
        new Twister02();
    }

    public Twister02() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new ExamplePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ExamplePane extends JPanel {

        private JSlider rotateSlider;
        private JSlider shearXSlider;
        private JSlider shearYSlider;
        private FieldPane fieldPane;
        private DefaultTransformModel transformModel;

        public ExamplePane() {

            setLayout(new BorderLayout());

            rotateSlider = new JSlider(0, 180);
            rotateSlider.setValue(0);
            rotateSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {

                    transformModel.setRotation(Math.toRadians(rotateSlider.getValue()));

                }
            });
            shearXSlider = new JSlider(-100, 100);
            shearXSlider.setValue(0);
            shearXSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {

                    double value = shearXSlider.getValue() / 200d;
                    transformModel.setShearX(value);

                }
            });
            shearYSlider = new JSlider(-100, 100);
            shearYSlider.setValue(0);
            shearYSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {

                    double value = shearYSlider.getValue() / 200d;
                    transformModel.setShearY(value);

                }
            });

            fieldPane = new FieldPane();

            transformModel = new DefaultTransformModel();
            transformModel.setRotation(Math.toRadians(0));
            transformModel.setScaleToPreferredSize(true);
            JXLayer<JComponent> rotatePane = TransformUtils.createTransformJXLayer(fieldPane, transformModel);

            JPanel sliders = new JPanel(new GridLayout(3, 0));
            sliders.add(rotateSlider);
            sliders.add(shearXSlider);
            sliders.add(shearYSlider);

            add(sliders, BorderLayout.NORTH);
            add(rotatePane);

        }
    }

    public class FieldPane extends JPanel {

        public FieldPane() {
            setLayout(new GridLayout(8, 8));
            for (int i = 0; i < 64; i++) {
                add(new JButton("" + i));
            }
        }

    }
}