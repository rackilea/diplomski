public int fun()
{
    // The following code will be executed by non event dispatching thread.
    final int[] choice = new int[1];
    SwingUtilities.invokeAndWait(new Runnable() {
        @Override
        public void run() {
            // Error.
            choice[0] = JOptionPane.showConfirmDialog(SaveToCloudJDialog.this, message, title, JOptionPane.YES_NO_OPTION);
        }            
    });
    return choice[0];
}