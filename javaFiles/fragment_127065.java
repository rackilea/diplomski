import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Grid extends JFrame{

    public Grid(){
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        final GridPanel panel = new GridPanel(300, 300, 4, 4);
        panel.setColor(1, 1, Color.RED); //change cell colors 
        panel.setColor(2, 3, Color.RED);
        add(panel);
        pack();
        setVisible(true);
    }
}

class GridPanel extends JPanel{

    //store reference to each cells
    Component[][] cells;

    public GridPanel (int width, int height, int rows, int columns){

        cells = new Component[rows][columns];
        //use grid layout to get the layout you want 
        setLayout(new GridLayout(rows, columns));
        setPreferredSize(new Dimension(width, height));
        for(int row =0; row < rows; row ++){
            for(int col =0; col < columns; col ++){
                Component cell = getCell();
                cells[row][col] = cell;
                add(cell);
            }
        }
    }

    //represent each cell as a label 
    Component getCell() {
        JLabel label = new JLabel();
        label.setBackground(Color.WHITE);
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return label;
    }

    //control color of each cell 
    void setColor(int row, int col, Color color) {
        cells[row][col].setBackground(color);
    }

    public static void main(String[] args) { new Grid();    }
}