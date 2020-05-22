public class YourClass { 

    private class Container {
        private TextField field = new TextField();
        private Button connectButton = new Button("Connecting...");
    }

    private final Container container = new Container();

    private void establishConnection() {
        container.connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // connection code here

                container.field.setText("Connection established"); // access to an inner class
            }
        });
    }
}