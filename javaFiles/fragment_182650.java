@Override
public void onDestroy() {
    super.onDestroy();

    if (serverSocket != null && !serverSocket.isClosed()) {
        try {
            serverSocket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}