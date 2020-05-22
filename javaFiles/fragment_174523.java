FileInputStream in = null;
ObjectInputStream ois = null;
ArrayList stuff2 = null;
try {
    in = openFileInput("saveGamesTest1.csv");
    ois = new ObjectInputStream(in);
    stuff2 = (ArrayList) ois.readObject();
} catch(IOException e) {...}
catch(ClassNotFoundException c) {...}
finally {
    if (ois != null) {
        ois.close();
    }
    if (in != null) {
        in.close();
    }
}