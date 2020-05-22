ArrayList<ArrayList<String>> listDic = new ArrayList<ArrayList<String>>();

BufferedReader reader = new BufferedReader(new FileReader(filename));

for (int countLine = 0;; countLine++) {
    String line = reader.readLine();
    if (line == null) {
        reader.close();
        break;
    }

    Scanner s = new Scanner(line);
    s.useDelimiter("\t(_\t)?");

    ArrayList<String> tokens = new ArrayList<String>();
    s.next(); // Skip the first token
    tokens.add(s.next());  // Take the second token (name)
    tokens.add(s.next());  // Take the third token (opt)
    listDic.add(tokens);

    System.out.println(listDic.get(countLine).get(0));
    System.out.println(listDic.get(countLine).get(1));
}