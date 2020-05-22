public void convertCSVToFlat () throws Exception {
    String csv="Justice_League.csv";
    BufferedReader bReader = new BufferedReader(new FileReader(csv));

    //We're storing the values at this 3 arraylists, 
    //but a better approach is using an object to hold'em
    ArrayList<String> lines = new ArrayList<String>();
    ArrayList<Integer> chars = new ArrayList<Integer>();
    ArrayList<String> hex = new ArrayList<String>();

    String line = "";
    try {
        while((line = bReader.readLine()) != null) {
            lines.add(line);
            //I'm assuming that you don't want to count the commas and spaces.
            //If you want to, comment the next line
            line = line.replaceAll(",", "").replaceAll(" ", "");
            int c = line.length(); //count remaining chars...
            chars.add(c);
            hex.add(Integer.toHexString(c));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    bReader.close();

    //Just to show the results
    for (int i = 0; i < lines.size(); i++) {
        System.out.print(lines.get(i));
        System.out.print("\t" + chars.get(i));
        System.out.println("\t" + hex.get(i));
    }
}