package SlidingTiles;

import ...;

public class Main 
{
    private static int timerDelay = 100;
    private static Timer t = new Timer(timerDelay, new TimerActionListener());

    private static JFrame jf = new JFrame();
    private static JPanel jp = new JPanel();
    private static String[] colors = { "blue", "brown", "green", "grey", "purple", "red", "yellow" };
    private static JLabel[] tiles = new JLabel[7];

    public static void main(String[] args) 
    {


        for(int i=0; i<7; ++i)
        {
            tiles[i] = new JLabel(new ImageIcon("tiles/"+colors[i]+".jpg"));
            tiles[i].setBounds(-120+60*i,0,60,90);
            jf.add(tiles[i]);
        }

        jf.add(jp);
        jf.setSize(186,120);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.start();
    }

    public static class TimerActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            for(int i=0; i<7; ++i)
            {
                Point p = tiles[i].getLocation();
                int newX = (int) p.getX()+5;
                if(newX == 300)
                    newX = -120;

                tiles[i].setLocation(newX, 0);
            }
        }
    }
}