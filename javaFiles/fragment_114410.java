public class Game extends JPanel
{
    static final int SCREEN_X = 300;
    static final int SCREEN_Y = 400;
    int x = 0;
    int y = 0;

    private void moveBall()
    {
        x += 1;
        y += 1;

        if (x >= SCREEN_X) {
            x = 0;
        }
        if (y >= SCREEN_Y) {
            y = 0;
        }
    }

    @Override
    public void paintComponent(Graphics g) { //for custom painting override paint componenet

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (x == 0 && y == 0)
        {
            // Generate random value in [0, 5)
            int rand_val = new Random().nextInt(5);

            // Init random color variable
            Color rand_color = Color.black;

            // Pick a random color
            switch (rand_val)
            {
            case 0:
                rand_color = Color.black;
                break;

            case 1:
                rand_color = Color.red;
                break;

            case 2:
                rand_color = Color.green;
                break;

            case 3:
                rand_color = Color.blue;
                break;

            case 4:
                rand_color = Color.gray;
                break;
            }

            g2d.setColor(rand_color);
            g2d.fillRect(0, 0, getWidth(), getHeight()); //clear screen 
        }

        g2d.fillOval(x, y, 30, 30);
    }