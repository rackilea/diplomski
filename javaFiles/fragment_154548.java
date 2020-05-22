public class ShapesMove extends JPanel{

    public static int x = 40;
    public static int y = 40;

    public static void main(String[] args){

        final JFrame frame = new JFrame("Movement of 2d Shapes");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final ShapesMove m = new ShapesMove();
        frame.getContentPane().add(m);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Action actionRight = new AbstractAction(){
            public void actionPerformed(ActionEvent actionRightEvent){
                x++;
                m.repaint();
            }
        };

        Action actionLeft = new AbstractAction(){
            public void actionPerformed(ActionEvent actionLeftEvent){
                x--;
                m.repaint();
            }
        };

        Action actionUp = new AbstractAction(){
            public void actionPerformed(ActionEvent actionUpEvent){
                y++;
                m.repaint();
            }
        };

        Action actionDown = new AbstractAction(){
            public void actionPerformed(ActionEvent actionDownEvent){
                y--;
                m.repaint();
            }
        };

        KeyStroke right = KeyStroke.getKeyStroke("RIGHT");
        KeyStroke left = KeyStroke.getKeyStroke("LEFT");
        KeyStroke up = KeyStroke.getKeyStroke("UP");
        KeyStroke down = KeyStroke.getKeyStroke("DOWN");

        InputMap inputMap = m.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(right, "RIGHT");
        inputMap.put(left, "LEFT");
        inputMap.put(up, "UP");
        inputMap.put(down, "DOWN");
        m.getActionMap().put("RIGHT", actionRight);
        m.getActionMap().put("LEFT", actionLeft);
        m.getActionMap().put("UP", actionUp);
        m.getActionMap().put("DOWN", actionDown);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(x, y, 60, 60);
    }

  }