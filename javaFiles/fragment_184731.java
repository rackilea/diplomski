import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Wall extends JApplet implements ActionListener {

//Component declaration
    JLabel directions;
    JTextField input = new JTextField(10);
    private JButton go;

    private WallPanel wallPanel;

//Method declaration
    public void init() {
        getContentPane().setBackground(new Color(128, 128, 128));//Changes backround of JApplet to black
        //Set JButton and JLabel
        setLayout(new BorderLayout());

        JPanel controls = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        directions = new JLabel("Enter in any number between 1 and 20 and then press Enter on your keyboard.");
        go = new JButton("Go!");
        go.setBackground(Color.GREEN);
        go.setFocusPainted(false);
        go.addActionListener(this);
        controls.add(directions, gbc);
        controls.add(input, gbc);
        controls.add(go, gbc);

        wallPanel = new WallPanel();

        add(controls, BorderLayout.NORTH);
        add(wallPanel);
    }

    public void actionPerformed(ActionEvent ae) {
        String text = input.getText();
        wallPanel.setRowCount(Integer.parseInt(text));
        repaint();
    }

    public class WallPanel extends JPanel {

        private int rowCount;

        public void setRowCount(int rowCount) {
            this.rowCount = rowCount;
            repaint();
        }

        public int getRowCount() {
            return rowCount;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 
            int startX = 50;
            int startY = 0;
            int width = 50;
            int height = 20;
            int spacing = 2;
            int xOffset = 0;
            for (int row = 0; row < getRowCount(); row++) {
                int y = startY + (row * (height + spacing));
                if (row % 2 == 0) {
                    xOffset = width / 2;
                } else {
                    xOffset = 0;
                }
                for (int col = 0; col < 8; col++) {
                    int x = xOffset + (startX + (col * (width + spacing)));
                    g.setColor(Color.RED);
                    g.fillRect(x, y, width, height);
                }
            }
        }

    }
}