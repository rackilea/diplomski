public void read(InputStream is) throws IOException {
    //You create a reader hold the input stream (sequence of data)
    //You create a BufferedReader which will wrap the input stream and give you methods to read your information
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    handleVerticeValues(reader);
    reader.close();
}

public void read(File file) throws IOException {
    //You create a buffered reader to manipulate the data obtained from the file representation
    BufferedReader reader = new BufferedReader(new FileReader(file));
    handleVerticeValues(reader);
    reader.close();
}

private void handleVerticeValues(BufferedReader reader) throws IOException {
    //Then you can read your file like this:
    String lineCursor = null;//Will hold the value of the line being read

    //Assuming your line has this format: 1.0 0.0 verticeA
    //Your separator between values is a whitespace character       
    while ((lineCursor = reader.readLine()) != null) {
        String[] lineElements = lineCursor.split(" ");//I use split and indicates that we will separate each element of your line based on a whitespace
        double valX = Double.parseDouble(lineElements[0]);//You get the first element before an whitespace: 1.0
        double valY = Double.parseDouble(lineElements[1]);//You get the second element before and after an whitespace: 0.0
        String label = lineElements[2];//You get the third element after the last whitespace 
        //You do something with your data
    }
}