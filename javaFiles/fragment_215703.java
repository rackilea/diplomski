public static void main(String[] args) throws Exception {
    //read in a works cited text file
    BufferedReader fin = new BufferedReader(new FileReader("Bibliography.txt"));

    ArrayList<String> lines = new ArrayList<String>();
    String line;
    while ((line = fin.readLine()) != null) {
        lines.add( line );
    }

    Collections.sort(lines);

    for( String s : lines )
    {
        System.out.println(s);
    }

    fin.close();                //close BufferedReader
}