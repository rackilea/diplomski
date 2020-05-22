import java.awt.BorderLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Example extends JFrame {

    private static JProgressBar progress;

    public static void main(String[] args) {
        final JFrame f = new JFrame();
        progress = new JProgressBar();
        progress.setStringPainted(true);
        progress.setIndeterminate(true);
        ExecutorService newCachedThreadPool = Executors.newFixedThreadPool(1);
        for( int i =0; i<10;i++){
            final int j = i;
            Runnable r = new Runnable() {

                @Override
                public void run() {
                    progress.setString(j+"");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            newCachedThreadPool.submit(r);
        }
        f.getContentPane().add(progress,BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

}