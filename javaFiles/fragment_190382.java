import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ScrollToVisible
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int n = 20;
        final JPanel panel = new JPanel(new GridLayout(1,0));
        final List<JComponent> components = new ArrayList<JComponent>();
        for (int i=0; i<n; i++)
        {
            JComponent component = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            component.setPreferredSize(new Dimension(100,100));
            component.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            components.add(component);
            panel.add(component);
        }
        final JScrollPane scrollPane = new JScrollPane(panel);

        final JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, n-1, 1));
        spinner.addChangeListener(new ChangeListener()
        {
            JComponent selectedComponent = components.get(0);

            @Override
            public void stateChanged(ChangeEvent e)
            {
                selectedComponent.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                int index = (Integer)spinner.getValue();
                JComponent component = components.get(index);
                Rectangle bounds = component.getBounds();

                // This would make the component "just" visible:
                //panel.scrollRectToVisible(bounds);

                // This will center the component:
                int cx = bounds.x + bounds.width / 2;
                int w = scrollPane.getViewport().getWidth();
                Rectangle r = new Rectangle(cx-w/2, bounds.y, w, bounds.height);
                panel.scrollRectToVisible(r);


                selectedComponent = component;
                selectedComponent.setBorder(BorderFactory.createLineBorder(Color.RED));

            }
        });

        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(scrollPane, BorderLayout.CENTER);
        f.getContentPane().add(spinner, BorderLayout.NORTH);


        f.setSize(800, 300);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}