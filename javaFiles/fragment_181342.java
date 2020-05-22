public static void readLines() {

    String file_path = "src/input.txt";
    ArrayList<String> lines = new ArrayList<>();

    try {
        try (Stream<String> stream = Files.lines(Paths.get(file_path))) {
            stream.forEach(lines::add);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }


    String everything = "";
    for (int i = 0; i < lines.size(); i++) {
      if(lines.get(i).length()>0){ // uncomment if you don not want to remove empty lines
          everything = everything +  lines.get(i);
      }
    }


    char[] chars = everything.toCharArray();
    for (int i = 0; i <chars.length ; i++) {
        System.out.println("Char at index "+i+"; "+ chars[i]);
    }
}