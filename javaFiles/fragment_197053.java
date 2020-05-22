public static String currenttxt() throws IOException{
    List<String> lines; 
    lines = Files.readAllLines(FileSystems.getDefault()
             .getPath(file.getAbsolutePath()));

    StringBuilder b = new StringBuilder();
    boolean insertNewLine = false;
    for (String line : lines) {
        if (insertNewLine) 
            b.append(System.getProperty("line.separator"));

        b.append(line);
        insertNewLine = true;       
    }

    return b.toString();
}