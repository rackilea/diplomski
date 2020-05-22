public class ServerGUI {

    private final JButton startServer = new JButton("Start server");
    int port;
    private JTextField portInput = new JTextField();
    private JTextArea eventsLog = new JTextArea();

    public ServerGUI(){
        startServer.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    port = Integer.parseInt(portInput.getText());
                }
                catch(NumberFormatException nfe){
                    appendEventsLog("");
                }
            }
        });
    }

    private void appendEventsLog(String msg) {
        String text = eventsLog.getText();
        eventsLog.setText(text + "\n" + msg);
    }
}