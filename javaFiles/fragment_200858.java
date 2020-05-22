public void writeMsg(String msg) {

        try {
            while((msg = reader.readLine()) != null) {
                writer.print("From client: " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }