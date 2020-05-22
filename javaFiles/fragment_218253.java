import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class EditablePanel extends JPanel
{
    private JLabel label;
    private JTextField field;

    public EditablePanel(String title)
    {
        super();
        setLayout(new OverlayLayout(this));
        setOpaque(false);

        add(label = new JLabel(title));
        label.setFocusable(false);

        field = new JTextField(title);
        field.setBorder(BorderFactory.createEmptyBorder());
        field.setVisible(false);
        field.addActionListener((e) -> finish(true));
        field.addFocusListener(new FocusListener()
        {
            @Override
            public void focusLost(FocusEvent e)
            {
                finish(false);
            }

            @Override
            public void focusGained(FocusEvent e)
            {
                // Nothing to do here
            }
        });
        add(field);

        TabMouseAdapter mouseAdapter = new TabMouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                if (e.getClickCount() == 2)
                {
                    label.setVisible(false);
                    field.setVisible(true);
                    field.requestFocusInWindow();
                    field.selectAll();
                }
            }
            @Override
            public void mousePressed(MouseEvent e)
            {
                super.mousePressed(e);
                finish(false);
            }

        };
        label.addMouseListener(mouseAdapter);
    }

    static class TabMouseAdapter implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            redispatch(e);
        }

        @Override
        public void mousePressed(MouseEvent e)
        {
            redispatch(e);
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            redispatch(e);
        }

        @Override
        public void mouseEntered(MouseEvent e)
        {
            redispatch(e);
        }

        @Override
        public void mouseExited(MouseEvent e)
        {
            redispatch(e);
        }

        private void redispatch(MouseEvent e)
        {
            Component source = e.getComponent();
            Component target = source.getParent();
            while (true)
            {
                if (target == null)
                {
                    break;
                }
                if (target instanceof JTabbedPane)
                {
                    break;
                }
                target = target.getParent();
            }
            if (target != null)
            {
                MouseEvent targetEvent =
                    SwingUtilities.convertMouseEvent(source, e, target);
                target.dispatchEvent(targetEvent);
            }
        }
    }

    private void finish(boolean commit)
    {
        if (commit)
        {
            label.setText(field.getText());
        }
        label.setVisible(true);
        field.setVisible(false);
        field.transferFocusUpCycle();
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Editable Tab Headers");
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTabbedPane pane = new JTabbedPane();
        pane.addTab("First Tab", new JLabel("First tab contents"));
        pane.addTab("Second Tab", new JLabel("Second tab contents"));
        pane.setTabComponentAt(0, new EditablePanel("First Tab"));
        pane.setTabComponentAt(1, new EditablePanel("Second Tab"));
        frame.add(pane);

        frame.pack();
        frame.setVisible(true);
    }
}