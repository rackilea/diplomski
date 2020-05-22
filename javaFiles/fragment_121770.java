import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;

public class UpdateService {
    private long value = 0;
    private final Gui gui;

    public UpdateService(Gui gui) {
        this.gui = gui;
    }

    public void startService() {

        // create executor that uses daemon threads;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1, runnable -> {
            Thread t = new Thread(runnable);
            t.setDaemon(true);
            return t;
        });
        Runnable loop = new Runnable() {
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        calculate();
                    }
                });
            }
        };

        executor.scheduleAtFixedRate(loop, 0, 100, TimeUnit.MILLISECONDS);

    }

    public void calculate() {
        double result = value++;
        gui.setResult(result);
    }

}