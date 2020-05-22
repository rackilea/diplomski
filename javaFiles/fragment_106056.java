//Let say you have file called variable.txt

BufferedReader br = new BufferedReader(new FileReader("variable.txt"));

try {
    String line = br.readLine();
    List<String> verifyItem = new ArrayList<String>();

    while (line != null) {
        verifyItem.add(line);
        line = br.readLine();
    }
} finally {
    br.close();
}

//do something with verifyItem