class RxThread extends Thread {
private static final String TEST = "0 0 0 0 0 40 0 0 ";
private static final String TEST2 = "0 1 0 0 0 41 0 0 ";
private static final String TEST3 = "2 bb 0 0 2 fb 0 0 ";
private static final String TEST4 = "2 bd 0 0 2 fd 0 0 ";
private static final String TEST5 = "2 be 0 0 2 fe 0 0 ";

Handler myHandler = new Handler();

public void run() {
while (true) {
    try {
        Thread.sleep(60);

        demoRxMsg = new MessageStructure();

        int progress = -1;
        while (rxChannel.receiveMessage(demoRxMsg) == ReturnCode.SUCCESS) {

            String data = "";
            String format = "";

            rxChannel.receiveMessage(demoRxMsg);

            if (demoRxMsg.frameFormat == API_ADK.STANDARD_FRAME) {
                format = "SFF";
            } else {
                format = "EFF";
            }
            for (byte i = 0; i < demoRxMsg.dataLength; i++) {
                data = data + Integer.toHexString(demoRxMsg.data[i])
                        + " ";
            }

            if (data.equalsIgnoreCase(TEST)) {
                progress = 0;
            } else if (data.equalsIgnoreCase(TEST2)) {
                progress = 1;
            } else if (data.equalsIgnoreCase(TEST3)) {
                progress = 94;
            } else if (data.equalsIgnoreCase(TEST4)) {
                progress = 95;
            } else if (data.equalsIgnoreCase(TEST5)) {
                progress = 96;
            }
        }
        if (progress != -1) {
            final int newProgress = progress;

            myHandler.post(new Runnable() {
                public void run() {
                    mProgressBar.setProgress(newProgress);
                }
            });
        }
    } catch (InterruptedException e) {
        break;
    }
}