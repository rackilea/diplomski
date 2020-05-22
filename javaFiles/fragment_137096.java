public class DrawPanel extends JPanel implements ActionListener {
    public static final int NUMBER_OF_CIRCLES = 10;

    Timer myTimer = new Timer(500, this);
    int[] circles = new int[NUMBER_OF_CIRCLES];

    public DrawPanel() {
        arrayFill(circles);

        if(NUMBER_OF_CIRCLES % 2 == 0) {
            condition = circles.length/2 -1;
        } else {
            condition = circles.length/2;
        }

        i = circles.length - 1;
        k = 1;

        myTimer.start();
    }

    int i, j, k;
    int condition;
    boolean outer = true;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(outer) {
            if(i > condition) {
                j = i - k;      // set j
                outer = false;  // and move to the inner loop swap
            } else {
                myTimer.stop(); // the outer loop is done so stop the timer
            }
        }
        if(!outer) {
            int tmp = circles[j];
            circles[j] = circles[j+1];
            circles[j+1] = tmp;
            repaint();

            j++;
            if(j >= i) {
                i--;
                k++;
                outer = true; // move to the outer condition
            }                 // next time the timer triggers
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        int x = 0;
        int length = 40;

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D circle;
        for(int index = 0; index<10; index++) {
            if(circles[index] == 0){
                circle = new Ellipse2D.Double(x, 120, length, length);
                g2.draw(circle);
            } else if(circles[index] == 1){
                circle = new Ellipse2D.Double(x, 120, length, length);
                g2.fill(circle);
            }
            x += 45;
        }
        //myTimer.start();
    }

    public static void arrayFill(int[] array) {
        for(int i = 0; i<array.length; i++) {
            if( i%2 == 0) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
    }
}