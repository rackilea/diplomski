import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class testWriteTimeToFile {

    public Writer writer = null;
    public File file;
    protected boolean isRunning = false;
    public Timer timer = null;

    public testWriteTimeToFile(int n) {
        // initComponents();
        initTimer();
        timer = new Timer();

        // run task every 4 seconds
        timer.schedule(new Task(1,2,3), 0, n * 1000);
    }

    public void initTimer() {
        this.isRunning = true;
        // tryToGetUpdateTime();
    }

    class Task extends TimerTask {

        private int a,b,c;      
        private double e,f,g;
        private String h,i,j;

        // take int
        public Task (int a, int b, int c){

            this.a = a;
            this.b = b;
            this.c = c;
        }

        // take double
        public Task (double e, double f, double g){

            this.e = e;
            this.f = f;
            this.g = g;
        }

        // take string
        public Task (String h, String i, String j){

            this.h = h;
            this.i = i;
            this.j = j;
        }

        @Override
        public void run() {
            final SimpleDateFormat sdfMonth = new SimpleDateFormat("dd/MM/yyyy");
            final SimpleDateFormat sdfHour = new SimpleDateFormat("HH:mm:ss");
            // only do it for 5 second
            file = new File("c:/test/time.txt");

            try {

                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferWritter = new BufferedWriter(fileWriter);

                Date date = new Date();

                bufferWritter.append(sdfMonth.format(date) + " "
                        + sdfHour.format(date) + '\n');

                bufferWritter.close();
            } catch (IOException ex) {
                System.err.println("Error in Writer : " + ex);
            }

        }

    }

    public static void main(String args[]) {

        new testWriteTimeToFile(4);

    }
}