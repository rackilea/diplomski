else if (event.getSource().equals(btnLeave)){
        if (!btnProcess.getModel().isEnabled()) {
            try {
                removeClient();
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            setVisible(false);
            dispose(); //Destroy the JFrame object.
        }
    }

public void removeClient()throws UnknownHostException, IOException {

    Socket s = new Socket("localhost", 5016);
    ObjectOutputStream p = new ObjectOutputStream(s.getOutputStream());

    p.writeObject(new Student("Remove Client!", 27, 2, "remove_client@gmx.com"));
    p.flush();

    BufferedReader response = new BufferedReader(new InputStreamReader(s.getInputStream()));

    txtArea.setText("The server respond: " + response.readLine() + "\r\n");
}