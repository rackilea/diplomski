public class LoginManager {

    private boolean bSSOEnabled = true;

    private void Login() {

        // get company details

        if(bSSOEnabled) {
            if (SwingUtilities.isEventDispatchThread()) {
                // already on EDT, just invoke the SSO which will block 
                // until the dialog is dismissed:
                new SSO();
            } else {
                // create FutureTask to show dialog, etc:
                FutureTask<Void> ssoTask = new FutureTask<>(SSO:new, null);
                // submit task to AWT event dispatch thread:
                SwingUtilities.invokeLater(ssoTask);
                // wait for task to complete, i.e. for dialog to be dismissed:
                try {
                    ssoTask.get();
                } catch (InterruptedException exc) {
                    // thread was interrupted, representing cancelation of some kind:
                    System.out.println("Thread interrupted");
                    Thread.currentThread().interrupt();
                } catch (ExecutionException ee) {
                    // something went wrong...
                    throw new RuntimeException(ee);
                }
            }
        }



    // once SSO is done, continue with execution
    }
}