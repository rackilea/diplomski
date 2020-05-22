public void run() {
        // Keep listening to the InputStream while connected
        while (true) {

            try {

                ObjectInputStream ois = new ObjectInputStream(mmInStream);
                Object contact = ois.readObject();
                Log.i(TAG,"Contact class: "+contact);

            } catch (IOException | ClassNotFoundException e) {
                Log.i("ERROR", "E:"+e.getLocalizedMessage());
            }
        }
    }