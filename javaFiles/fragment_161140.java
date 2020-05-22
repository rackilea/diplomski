import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class ClosableTab extends JPanel implements ActionListener{

    private final JTabbedPane pane;
    private final int index;

    private JButton closeButton;

    private JLabel titleLabel;

    public ClosableTab(final JTabbedPane pane, final int index){
        super(new BorderLayout());
        setOpaque(false);

        this.pane = pane;
        this.index = index;

        titleLabel = new JLabel(pane.getTitleAt(index));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        closeButton = new JButton("X");
        closeButton.setBorder(new EmptyBorder(-5, 2, -5, 0));
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setFont(closeButton.getFont().deriveFont(20F));
        closeButton.setForeground(Color.RED);
        closeButton.addActionListener(this);

        add(titleLabel, BorderLayout.CENTER);
        add(closeButton, BorderLayout.EAST);

        setPreferredSize(getPreferredSize());
    }

    public void actionPerformed(ActionEvent e){
        final Object source = e.getSource();
        if(source.equals(closeButton)){
            pane.remove(pane.indexOfTabComponent(this));
            pane.revalidate();
            pane.repaint();
        }
    }

    public void apply(){
        pane.setTabComponentAt(index, this);
        pane.revalidate();
        pane.repaint();
    }

    public static void apply(final JTabbedPane pane, final int index){
        new ClosableTab(pane, index).apply();
    }

}