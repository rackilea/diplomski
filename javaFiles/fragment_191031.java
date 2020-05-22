for (MyRecord record : records) {
        oos.writeObject(record);
    }
    oos.flush();
    Object received = ois.readObject();
    System.out.println(received);