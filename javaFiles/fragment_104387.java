//uri where your file is 
String fileName = "c://lines.txt";
// read the file into a buffered reader
try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

    String line;
    while ((line = br.readLine()) != null) { //iterate on each line of the file
        System.out.println(line); // print it if you want 
        String[] split=line.split(" "); // split your line into array of strings, each one is a separate word that has no spaces in it.
        //add any checks or extra processes here 
    }

} catch (IOException e) {
    e.printStackTrace();
}