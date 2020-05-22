public static String[] getArrayStringRandom() {
    try {
        List<String> list = new LinkedList<String>();
        FileReader fileReader = new FileReader("file.txt");
        BufferedReader in = new BufferedReader(fileReader);
        for (String name; (name = in.readLine()) != null;) {
            list.add(name);
        }
        in.close();
        fileReader.close();
        // Collections.shuffle(list); // Random permutes
        return list.toArray(new String[0]);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}