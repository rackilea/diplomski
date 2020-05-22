public void TextFileWritingExample1() {

    try {
        FileWriter writer = new FileWriter("MyFile.txt", true);
        for (int i = 0; i < prvky.length; i++) {
            for (int j = 0; j < prvky[i].length; j++) {
                  writer.write(prvky[i][j]+" ";
            }
            //this is the code that you change, this will make a new line between each y value in the array
            writer.write("\n");   // write new line
        }
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

}