FileReader fr = new FileReader("file.txt");
    BufferedReader br = new BufferedReader(fr);
    String line;

    List<String> list = new ArrayList<String>();
    while ((line = br.readLine()) != null){
        list.add(line);
    }
    br.close();
    // do whatever you have to with this list