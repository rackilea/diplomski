private ArrayList<String> readFromFile(Context context) {
    ArrayList<String> list = new ArrayList<String>();
    try {
        ObjectInputStream ois = new ObjectInputStream( context.openFileInput("jokesBody1.bjk"));
        try {
            list = (ArrayList)ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ois.close();
        } catch (IOException e) {
        Log.e("log activity", "Can not read file: " + e.toString());
    }

    return list;
}