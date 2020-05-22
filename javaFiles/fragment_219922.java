@FXML 
private void btnLogOut_Click() {
    // update ui
    lblStatus.setText("Logging out..");

    // delay & exit on other thread
    new Thread(() -> {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        System.exit(0);
    }).start();
}