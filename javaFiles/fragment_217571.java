public boolean reset() {
        DataInputStream is;
        DataOutputStream os;
        boolean result = true;
        String noReset = "Could not reset.";
        String reset = "The server has been reset.";

        try {
            Socket socket = new Socket(InetAddress.getByName("x.x.x.x"), 3994);
            String string = "{\"id\":1,\"method\":\"object.deleteAll\",\"params\":[\"subscriber\"]}";
            is = new DataInputStream(socket.getInputStream());
            os = new DataOutputStream(socket.getOutputStream());
            PrintWriter pw = new PrintWriter(os);
            pw.println(string);
            pw.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            JSONObject json = new JSONObject(in.readLine());
            if(!json.has("result")) {
                System.out.println(noReset);
                result = false;
            }
            is.close();
            os.close();

        } catch (IOException e) {
            result = false;
            System.out.println(noReset);
            e.printStackTrace();            
        } catch (JSONException e) {
            result = false;
            System.out.println(noReset);
            e.printStackTrace();
        }
        System.out.println(reset);
        return result;
    }