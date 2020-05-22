try {
    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    while (run) {
        serverMessage = in.readLine();
        mHandler.post(new DisplayToast(context, "TCP : " + serverMessage));
    }
}