import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class ExampleFrame extends JFrame {

    private JLabel output = new JLabel("Initial");

    public static void main(String[] args) {
        // Construct and show a new JFrame (ExampleFrame) on the EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExampleFrame();
            }
        });
    }

    public ExampleFrame() {
        System.out.println("Running ExampleFrame() constructor on EDT: " + SwingUtilities.isEventDispatchThread());

        // Setup GUI
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(output);
        pack();
        setVisible(true);

        // Implement the abstract methods of GuiWorker and invoke execute() to run
        new GuiWorker() {

            @Override
            public void backgroundProcess() {
                // To be run on a background thread

                int i = 0;
                // iterate 10 times, sleeping for 500 ms
                // printing i to the console
                while (i < 10) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(i);
                    i++;
                }
            }

            @Override
            public void postExecute() {
                // when the backgroundProcess has finished
                // update the output JLabel on the EDT
                output.setText("Finished");
            }
        }.execute(); // invoke execute to start the worker
    }

}