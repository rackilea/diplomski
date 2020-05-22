import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringJoiner;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class View extends JPanel {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DrawLines drawLines = new DrawLines();
                JFrame frame = new JFrame();
                frame.setGlassPane(drawLines);
                frame.add(new View(20, 20, drawLines));
                frame.getGlassPane().setVisible(true);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    enum Token {
        VIDE, CERCLE_BLEU, CERCLE_ROUGE
    }

    private static final int ICON_W = 20;
    public static final String CELL_SELECTION = "cell selection";
    private int rows;

    private Token[][] tokens;
    private JLabel[][] grid;
    private Map<Token, Icon> iconMap = new EnumMap<>(Token.class);
    private int selectedRow;
    private int selectedCol;
    private DrawLines drawLines;

    View(int rows, int cols, DrawLines drawLines) {
        this.drawLines = drawLines;
        iconMap.put(Token.VIDE, createIcon(new Color(0, 0, 0, 0)));
        iconMap.put(Token.CERCLE_BLEU, createIcon(Color.BLUE));
        iconMap.put(Token.CERCLE_ROUGE, createIcon(Color.RED));
        createGrid(rows, cols);
    }

    private Icon createIcon(Color color) {

        BufferedImage img = new BufferedImage(ICON_W, ICON_W, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        g2.fillOval(1, 1, ICON_W - 2, ICON_W - 2);
        g2.dispose();

        return new ImageIcon(img);
    }

    void createGrid(int rows, int cols) {

        tokens = new Token[rows][cols];

        MyMouseListener listener = new MyMouseListener();
        setRows(rows);

        setLayout(new GridLayout(rows, cols, 1, 1));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.DARK_GRAY);
        grid = new JLabel[rows][cols];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c] = new JLabel(iconMap.get(Token.VIDE));
                grid[r][c].addMouseListener(listener);
                grid[r][c].setOpaque(true);
                grid[r][c].setBackground(Color.WHITE);
                grid[r][c].setPreferredSize(new Dimension(ICON_W, ICON_W));
                add(grid[r][c]);
            }
        }

        set(6, 6, Token.CERCLE_ROUGE);
        set(6, 7, Token.CERCLE_ROUGE);
        set(6, 8, Token.CERCLE_ROUGE);
        set(6, 9, Token.CERCLE_ROUGE);
        set(7, 9, Token.CERCLE_ROUGE);
        set(8, 9, Token.CERCLE_ROUGE);
        set(9, 9, Token.CERCLE_ROUGE);
        set(10, 9, Token.CERCLE_ROUGE);
        set(10, 6, Token.CERCLE_ROUGE);
        set(10, 7, Token.CERCLE_ROUGE);
        set(10, 8, Token.CERCLE_ROUGE);
        set(10, 9, Token.CERCLE_ROUGE);
        set(7, 6, Token.CERCLE_ROUGE);
        set(8, 6, Token.CERCLE_ROUGE);
        set(9, 6, Token.CERCLE_ROUGE);

        Path path = new Path(tokens);
        if (path.findPath(new int[]{6, 6})) {

            addPath(path.getPath());
        }
    }

    void set(int row, int col, Token token) {
        grid[row][col].setIcon(iconMap.get(token));
        tokens[row][col] = token;
    }

    int getSelectedRow() {
        return selectedRow;
    }

    int getSelectedCol() {
        return selectedCol;
    }

    void setCell(Token token, int row, int col) {

        grid[row][col].setIcon(iconMap.get(token));
    }

    int getRows() {
        return rows;
    }

    void setRows(int rows) {
        this.rows = rows;
    }

    //added to each cell to listen to mouse clicks
    //fires property change with cell index
    private class MyMouseListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            JLabel selection = (JLabel) e.getSource();
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[r].length; c++) {
                    if (selection == grid[r][c]) {
                        selectedRow = r;
                        selectedCol = c;
                        int index = (r * grid[r].length) + c;
                        selection.setIcon(iconMap.get(Token.CERCLE_BLEU));
                        tokens[selectedRow][selectedCol] = Token.CERCLE_BLEU;
                        System.out.println(c + "x" + r + " = " + index);
                        firePropertyChange(CELL_SELECTION, -1, index);

                        Path path = new Path(tokens);
                        if (path.findPath(new int[]{selectedRow, selectedCol})) {
                            addPath(path.getPath());
                        }
                    }
                }
            }
        }
    }

    //add listener to listen to property changes fired by MyMouseListener
    @Override
    public void addPropertyChangeListener(PropertyChangeListener viewListener) {

        addPropertyChangeListener(viewListener);
    }

    private void addPath(ArrayList<Cell> path) {

        if (path != null) {
            List<JLabel> labels = new ArrayList<>(25);
            for (Cell cell : path) {
                JLabel label = grid[cell.y][cell.x];
                label.setBackground(Color.YELLOW);
                labels.add(label);
            }
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[r].length; c++) {

                    if (!path.contains(new Cell(c, r))) {
                        grid[r][c].setBackground(Color.WHITE);
                    }

                }
            }

            drawLines.addPath(labels);
        }
    }

    public static class DrawLines extends JLabel {

        private List<List<JLabel>> history;

        DrawLines(){
            history = new ArrayList<>();
        }

        public void addPath(List<JLabel> path) {

            path.add(path.get(0)); //add path origin as target
            history.add(path);
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            if ((history == null) || history.isEmpty()) {
                return;
            }

                Graphics2D g2d = (Graphics2D) g.create();

                for(List<JLabel> path : history) {
                     Point startPoint = null;
                    for (JLabel label : path) {
                        g2d.setColor(Color.DARK_GRAY);
                        Point endPoint = label.getLocation();
                        endPoint.x += (label.getWidth() / 2);
                        endPoint.y += (label.getHeight() / 2);
                        if (startPoint != null) {
                            g2d.draw(new Line2D.Float(startPoint, endPoint));
                        }
                        startPoint = endPoint;
                    }
                }
                g2d.dispose();
        }

    }

    class Cell {

        private int x, y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Cell other = (Cell) obj;
            if (x != other.x) {
                return false;
            }
            if (y != other.y) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return x + "x" + y;
        }

    }

    class Path extends Stack<Cell> {

        private Token[][] grid;

        //a path shorter than min can not surround any cell
        private static final int MIN_PATH_LEGTH = 3;

        //a collection of cells that has been tested
        private ArrayList<Cell> checked;

        //represents the cell where the search starts from
        Cell origin;
        //represents the token of the origin
        Token originToken;

        private int rows;
        private int cols;

        Path(Token[][] grid) {

            this.grid = grid;
            rows = grid.length;
            cols = grid[0].length;
        }

        //search for a path
        boolean findPath(int[] origin) {

            int row = origin[0], col = origin[1];
            this.origin = new Cell(col, row);

            //represents the token of the origin
            originToken = grid[row][col];

            //initialize list of checked items
            checked = new ArrayList<>();

            boolean found = findPath(row, col);

            if (found) {
                printPath();
            } else {
                System.out.println("No path found");
            }

            return found;
        }

        //recursive method to find path. a cell is represented by its row, col
        //returns true when path was found
        private boolean findPath(int row, int col) {

            //check if cell has the same token as origin
            if (grid[row][col] != originToken) {
                return false;
            }

            Cell cell = new Cell(col, row);

            //check if this cell was tested before to avoid checking again
            if (checked.contains(cell)) {
                return false;
            }

            //get cells neighbors
            ArrayList<Cell> neighbors = getNeighbors(row, col);

            //check if solution found. If path size > min and cell
            //neighbors contain the origin it means that path was found
            if ((size() >= MIN_PATH_LEGTH) && neighbors.contains(origin)) {

                add(cell);
                return true;
            }

            //add cell to checked list
            checked.add(cell);

            //add cell to path
            add(cell);

            //if path was not found check cell neighbors
            for (Cell neighbor : neighbors) {

                boolean found = findPath(neighbor.getY(), neighbor.getX());
                if (found) {
                    return true;
                }
            }

            //path not found
            pop(); //remove last element from stack
            return false;
        }

        //return a list of all neighbors of cell row, col
        private ArrayList<Cell> getNeighbors(int row, int col) {

            ArrayList<Cell> neighbors = new ArrayList<>();

            for (int colNum = col - 1; colNum <= (col + 1); colNum += 1) {

                for (int rowNum = row - 1; rowNum <= (row + 1); rowNum += 1) {

                    if (!((colNum == col) && (rowNum == row))) {

                        if (withinGrid(rowNum, colNum)) {

                            neighbors.add(new Cell(colNum, rowNum));
                        }
                    }
                }
            }

            return neighbors;
        }

        private boolean withinGrid(int colNum, int rowNum) {

            if ((colNum < 0) || (rowNum < 0)) {
                return false;
            }
            if ((colNum >= cols) || (rowNum >= rows)) {
                return false;
            }
            return true;
        }

        //use for testing
        private void printPath() {
            StringJoiner sj = new StringJoiner(",", "Path: ", "");
            for (Cell cell : this) {
                sj.add(cell.toString());
            }
            System.out.println(sj);

        }

        public ArrayList<Cell> getPath() {
            ArrayList<Cell> cl = new ArrayList<>();
            cl.addAll(this);
            return cl;
        }
    }
}