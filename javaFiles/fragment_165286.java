try {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(ipAddress, 5006), 5000);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message = reader.readLine();
        reader.close();
        socket.close();
        Log.i("TAG", message);
        } catch (IOException e) {
        e.printStackTrace();
     }