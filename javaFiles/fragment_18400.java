try {
    FileReader read = new FileReader("amounts.txt");//Read text file.
    strings = new Scanner(read);
    String skip = strings.nextLine();//Skip the first line by storing it in an uncalled variable
}
catch (FileNotFoundException error) { }

String line;
while ((line = strings.nextLine()) != null) {            
     String[] parts = line.split("\t");
     //...
}