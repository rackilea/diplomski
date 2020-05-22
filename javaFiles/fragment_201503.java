protected Map<Integer, Word> deserializeCM(String f) {
    String path = System.getProperty("user.dir") + "\\" + f;

    try {
        Map<Integer, String> map = new LinkedHashMap<Integer, Word>();
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(path));
        map = (LinkedHashMap<Integer, Word>) is.readObject();
        is.close();

        return map;
    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}