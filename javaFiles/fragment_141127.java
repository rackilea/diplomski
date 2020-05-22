import java.util.concurrent.atomic.AtomicBoolean;

public class CameraCapture {

    private AtomicBoolean doCapture = new AtomicBoolean();

    public Thread startCapture() {
        System.out.println("Setting Capture status to true");
        doCapture.set(true);


        Thread capture = new Thread(new Runnable() {
            public void run() {
                System.out.println("Initializing Sources");
               /* Initialization Code here. */
                System.out.println("Found WebCam!");

                System.out.println("Configuring Codec");

                while(doCapture.get()) {
                    System.out.println("\tReading Data!");
                    //Read and handle input.
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException exception) {
                        // FIXME:  minimum of logging.
                        exception.printStackTrace();
                    }
                }

                System.out.println("Capture Terminated!");

            }}, "CameraCapture Injest"); //Name the thread!

        System.out.println("Starting Capture");        
        capture.start();
        return capture;
    }

    public void stopCapture() {
        System.out.println("Disabling capture");
        doCapture.set(false);
    }
}