public static void main(String[] args) throws Exception {
    FileReader fr = new FileReader("sample.txt");
    BufferedReader reader = new BufferedReader(fr);
    String line = "";

    ArrayList<String> linee = new ArrayList<String>();

    while ((line = reader.readLine()) != null) {
        if (line.equals("bb"))
            break;
        linee.add(line);

    }

    reader.close();
    for (int i = linee.size() - 1; i >= 0; i--)
        System.out.println(linee.get(i));

}