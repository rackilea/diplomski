while (true) {
        try {
            Object input = in.readObject();
            message = (String) input;
        } catch (IOException e) {
            e.printStackTrace();
            break; //unrecoverable
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            break; //unrecoverable
        }

        console("Client : " + message);
    }