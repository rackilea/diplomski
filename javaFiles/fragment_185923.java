import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FpsDemo extends JFrame implements Runnable {
    // statics
    private final static int SCREENHEIGHT = 800;
    private final static int SCREENWIDTH = 1200;
    private final static int NOF_SNOWFLAKES = 1000;
    private final static int NOF_SPEEDS = 5;
    private final static int BACKGROUND = colour(0xB, 0x16, 0x2C);      
    private final static int WHITE = colour(0xFF, 0xFF, 0xFF);

    // for each snowflake [i], [i][0] = x coord, [i][1] = y coord and [i][2] = speed
    private final static int snow[][] = new int[NOF_SNOWFLAKES][3];

    // for each column, a height
    private final static int pile[] = new int[SCREENWIDTH];


    /* Code entry point */
    public static void main(String[] args) {
        new FpsDemo().run();
    }


    /* Instantiates an instance of this class */
    public FpsDemo() {
        super("My FPS Demo");
        setSize(SCREENWIDTH, SCREENHEIGHT);
        setVisible(true);
    }


    /* Contains the main loop */
    @Override
    public void run() {
        // setup an off-screen buffer to draw to
        BufferedImage screen = new BufferedImage(SCREENWIDTH, SCREENHEIGHT, BufferedImage.TYPE_INT_RGB);
        int[] screenData = ((DataBufferInt) screen.getRaster().getDataBuffer()).getData();
        Graphics gs = getGraphics();
        gs.setColor(Color.white);

        // prepare some colours
        int[] shades = new int[NOF_SPEEDS+1];
        for(int i=0; i<NOF_SPEEDS; i++) {
            int j = 50 + i * ((255-50)/NOF_SPEEDS);
            shades[NOF_SPEEDS-i] = colour(j, j, j);
        }

        // arrange our initial data
        Random random = new Random();
        Arrays.fill(pile, SCREENHEIGHT);
        for(int i=0; i<NOF_SNOWFLAKES; i++) {
            snow[i][0] = random.nextInt(SCREENWIDTH);
            snow[i][1] = random.nextInt(SCREENHEIGHT);
            snow[i][2] = random.nextInt(4) + 1;
        }

        // loop forever (well, until an ArrayOutOfBoundsException...)
        double fps = 0;
        int frameCount = 0;
        long startTime = System.nanoTime();
        int throttle = NOF_SPEEDS;
        while(true) {
            Arrays.fill(screenData, BACKGROUND);

            // For each pile
            for(int x=0; x<SCREENWIDTH; x++) {
                for(int y=pile[x], j=x+pile[x]*SCREENWIDTH; y<SCREENHEIGHT; y++, j+=SCREENWIDTH) {
                    screenData[j] = WHITE;
                }
            }

            // For each snow flake
            for(int i=0; i<NOF_SNOWFLAKES; i++) {
                // Render the snow flake to the off-screen buffer
                int j = snow[i][0]+(snow[i][1]*SCREENWIDTH);
                screenData[j] = shades[snow[i][2]];

                // Update for next render
                if(snow[i][2] < throttle) {
                    // check the next row down
                    if(snow[i][1]+1 < pile[ snow[i][0] ] && snow[i][1] < SCREENHEIGHT) {
                        snow[i][1]++;

                    // slide left
                    } else if(snow[i][0]>1 && snow[i][1]+1 < pile[ snow[i][0]-1 ] && snow[i][1] < SCREENHEIGHT) {
                        snow[i][1]++;
                        snow[i][0]--;

                    // slide right
                    } else if(snow[i][0]<SCREENWIDTH-1 && snow[i][1]+1 < pile[ snow[i][0]+1 ] && snow[i][1] < SCREENHEIGHT) {
                        snow[i][1]++;
                        snow[i][0]++;

                    // we hit the pile                      
                    } else {
                        pile[snow[i][0]]--;
                        snow[i][1] = random.nextInt(SCREENWIDTH);
                        snow[i][1] = 0;
                        snow[i][2] = random.nextInt(4) + 1;
                    }
                }
            }

            // Flip the image buffer across in one go.
            if (gs!=null) {
                gs.drawImage(screen, 0, 0, null);
            }

            // Select less snow flakes each loop so we get a parallax effect 
            throttle--;
            if(throttle == 0) {
                throttle = NOF_SPEEDS;
            }

            // Update FPS 
            frameCount++;
            long now = System.nanoTime();
            // has it been more than 1 second (1bn nanos)?
            long wallclock = now - startTime;
            if(wallclock > 1000000000) {
                fps = frameCount / (wallclock/1000000000);
                startTime = now;
                frameCount = 0;
                this.setTitle("FPS: " + fps);
            }

            // You could try calculating a delay to achieve a specific FPS
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /* Convenience method to convert RGB values (in the range 0-255) into a single integer */
    private static int colour(int r, int g, int b) {
        return (r*65536) + (g*256) + b;
    }
}