import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class TalkToEachOther {

    public static void main(String[] args) {
        new TalkToEachOther();
    }

    public TalkToEachOther() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Simple Example");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                MutableSimpleModel model = new DefaultSimpleModel();

                SimpleTextPanel text = new SimpleTextPanel(model);
                SimpleButtonPanel button = new SimpleButtonPanel(model);

                frame.add(text, BorderLayout.NORTH);
                frame.add(button, BorderLayout.SOUTH);
                //button.addPropertyChangeListener(text); // so that text editor knows whether to allow writing or not
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public interface SimpleModel {

        public boolean isEditable();

        public void addPropertyChangeListener(PropertyChangeListener listener);
        public void removePropertyChangeListener(PropertyChangeListener listener);

    }

    public interface MutableSimpleModel extends SimpleModel {

        public void setEditable(boolean editable);

    }

    public class DefaultSimpleModel implements MutableSimpleModel {

        private Set<PropertyChangeListener> listeners;
        private boolean editable;

        public DefaultSimpleModel() {
            listeners = new HashSet<>(25);
        }

        @Override
        public void setEditable(boolean value) {
            if (value != editable) {
                editable = value;
                firePropertyChange("editable", !editable, editable);
            }
        }

        @Override
        public boolean isEditable() {
            return editable;
        }

        @Override
        public void addPropertyChangeListener(PropertyChangeListener listener) {
            listeners.add(listener);
        }

        @Override
        public void removePropertyChangeListener(PropertyChangeListener listener) {
            listeners.remove(listener);
        }

        protected void firePropertyChange(String editable, boolean oldValue, boolean newValue) {
            PropertyChangeEvent evt = new PropertyChangeEvent(this, editable, oldValue, newValue);
            for (PropertyChangeListener listener : listeners) {
                listener.propertyChange(evt);
            }
        }

    }

    public class SimpleTextPanel extends JPanel {

        private SimpleModel model;
        private JTextArea editSpace = new JTextArea(10, 20);

        public SimpleTextPanel(SimpleModel model) {

            this.model = model;
            model.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    updateEditableState();
                }
            });
            setLayout(new BorderLayout());

            // set the border properties
            TitledBorder title = BorderFactory.createTitledBorder("Simple Text Panel");
            title.setTitleColor(Color.BLACK);
            title.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,
                            Color.DARK_GRAY, Color.GRAY));
            this.setBorder(title);

            editSpace = new JTextArea(10, 20);
            this.add(new JScrollPane(editSpace));

            updateEditableState();
        }

        protected void updateEditableState() {
            editSpace.setEditable(model.isEditable());
        }
    }

    public class SimpleButtonPanel extends JPanel implements ActionListener {

        private MutableSimpleModel model;
        private boolean canWrite = true;

        private JButton switchButton;

        public SimpleButtonPanel(MutableSimpleModel model) {

            this.model = model;
            model.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    updateEditableState();
                }
            });

            // set the border properties
            TitledBorder title = BorderFactory.createTitledBorder("Simple Button Panel");
            title.setTitleColor(Color.BLACK);
            title.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,
                            Color.DARK_GRAY, Color.GRAY));
            this.setBorder(title);

            switchButton = new JButton("Start");
            switchButton.addActionListener(this);
            this.add(switchButton);

            updateEditableState();
        }


        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            model.setEditable(!model.isEditable());
        }

        protected void updateEditableState() {
            if (model.isEditable()) {
                switchButton.setText("Stop");
            } else {
                switchButton.setText("Start");
            }
        }
    }
}