public static void main(String[] args) throws IOException {
    FileReader f;
    f=new FileReader("output.csv");

    BufferedReader b;
    b=new BufferedReader(f);

    String firstLine= b.readLine();
    int uniform = firstLine.indexOf("uniform");
    firstLine=firstLine.substring(0, uniform);
    firstLine = firstLine + "uniform.0,uniform.1,uniform.2\n";

    File file = new File("outputForNeo4j.csv");
    if(!file.createNewFile()) {
        // all work would be for nothing! Bailing out.
        return;
    }

    PrintWriter pw = new PrintWriter(file); 
    pw.print(firstLine);

    while(true) {
        String line=b.readLine();
        if(line==null)
            break;
        int u = line.indexOf("\"[");
        line=line.substring(0, u);
        line=line + "first_colour,second_colour,third_colour \n";
        pw.print(line);                   
    }

    System.out.println("New file \"outputForNeo4j.csv\" created.");
    pw.flush();
    pw.close();
    b.close()
}