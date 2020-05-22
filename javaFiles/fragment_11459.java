import javax.swing.SwingUtilities;

public abstract class GuiWorker {

    public abstract void backgroundProcess(); // method called on background thread

    public abstract void postExecute(); // method called on EDT

    public void execute() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running backgroundProcess() on EDT: " + SwingUtilities.isEventDispatchThread());

                // Execute backgroundProcess() on this background thread
                backgroundProcess();

                // When backgroundProcess() pops, run postExecute() on the EDT
                System.out.println("End of background process.");
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Running postExecute() on EDT: " + SwingUtilities.isEventDispatchThread());
                        postExecute();
                    }
                });
            }
        }).start(); // start background thread
    }

}