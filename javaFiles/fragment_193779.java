public static void send(Connection c, Object o){
    try {
        c.getObjectOutputStream().writeObject(o);

        // !!!!!! THIS SOLVED MY PROBLEM !!!!!!

        c.getObjectOutputStream().reset();
    } catch (IOException e) {
        e.printStackTrace();
    }
}