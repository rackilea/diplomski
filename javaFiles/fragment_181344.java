public static void readFile() {

    ArrayList<String> allStrings = new ArrayList<>();


    String file_path = "src/input.txt";
    String everything;
    BufferedReader br = null;
    try {
        br = new BufferedReader(new FileReader(file_path));

        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            if (line.length() > 0) {
                allStrings.add(line);
            }
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        everything = sb.toString();


        //Convert to array
        String[] everyString = new String[allStrings.size()];
        System.out.println("Everything: " + everything);
        for (int i = 0; i < allStrings.size(); i++) {
            everyString[i] = allStrings.get(i);
        }


        //Print Array
        for (int i = 0; i < allStrings.size(); i++) {
            System.out.println("Index: " + everyString[i]);
        }

        br.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}