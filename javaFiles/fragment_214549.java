public class LineEditor extends JComponent{

    private static class Point{
        final int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static class Line{
        final Point a, b;  
        final Color color;

        public Line(Point a, Point b, Color color) {
            this.a = a;
            this.b = b;
            this.color = color;
        }               
    }

    private final LinkedList<Line> lines = new LinkedList<Line>();

    public void addLine(int xa, int ya, int xb, int yb, Color color) {
        lines.add(new Line(new Point(xa, ya), new Point(xb, yb), color));        
        repaint();
    }

    public void clearScreen() {
        if(lines.size() > 0){
            lines.remove(lines.getLast());
            repaint();
        }   
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Line line : lines) {
            g.setColor(line.color);
            g.drawLine(line.a.x, line.a.y, line.b.x, line.b.y);
        }
    }

    public static void main(String[] args) {
        int width, height;
        width = 500;
        height = 500;

        JFrame backgroundFrame = new JFrame();
        backgroundFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final LineEditor lineEditor = new LineEditor();
        lineEditor.setPreferredSize(new Dimension(width, height));
        backgroundFrame.getContentPane().add(lineEditor, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
            JButton clearScreen = new JButton("Remove last line");
            buttonsPanel.add(clearScreen);
            backgroundFrame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);

        backgroundFrame.addMouseListener(new MouseAdapter() {
            int ax, ay, bx, by;
            Color color;
            Boolean colorSetted = false;
            @Override
            public void mouseEntered(MouseEvent e) {
                if(!colorSetted){
                    JColorChooser colorChooser =new JColorChooser();
                    this.color = colorChooser.showDialog(null, "Select a color", Color.BLACK);
                    colorSetted = true;
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                ax = e.getX();
                ay = e.getY();
                System.out.println("Mouse pressed: " + ax + ", " + ay);


            }

            @Override
            public void mouseReleased(MouseEvent e) {
                bx = e.getX();
                by = e.getY();
                System.out.println("Mouse released: " + bx + ", " + by);
                lineEditor.addLine(ax, ay, bx, by, color);
                colorSetted = false;
            }
        });

        clearScreen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lineEditor.clearScreen();
            }
        });

        backgroundFrame.pack();
        backgroundFrame.setVisible(true);
    }
}