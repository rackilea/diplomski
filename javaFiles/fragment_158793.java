public class SocketReader extends SwingWorker<Void, String> {

    private List<ActionListener> actionListeners;

    public SocketReader() {
        actionListeners = new ArrayList<>(25);
    }

    public void addActionListener(ActionListener listener) {
        actionListeners.add(listener);
    }

    public void removeActionListener(ActionListener listener) {
        actionListeners.remove(listener);
    }

    @Override
    protected Void doInBackground() throws Exception {
        System.out.println("Connected to Server!");

        try (DataInputStream in = new DataInputStream(SocketManager.INSTACNE.getInputStream())) {

            System.out.println("Before setting text area");

            String serverInput = null;
            do {
                // HANDLE INPUT PART HERE
                serverInput = in.readUTF();

                if (serverInput != null) {
                    System.out.println("Read " + serverInput);
                    publish(serverInput);
                }

            } while (!serverInput.equals("/close"));
            System.out.println("Program closed");
        }
        return null;
    }

    @Override
    protected void process(List<String> chunks) {
        for (String text : chunks) {
            ActionEvent evt = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, text);
            for (ActionListener listener : actionListeners) {
                listener.actionPerformed(evt);
            }
        }
    }

}