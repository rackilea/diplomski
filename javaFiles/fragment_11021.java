Scanner in = new Scanner(new File("./myfile.txt"));
while(in.hasNextLine()){
    //read in a whole line
    String line = in.nextLine();

    //sanity check so we don't try to substring an empty string from an empty line at the end of the file.
    if(line.length() == 0){
        continue;
    }

    //15 chars from the end it 8 chars + 7 spaces
    //We go back 16 though since the string index starts at 0, not 1.
    line = line.subString(line.length()-16, line.length()-1);

    //Now split the string based on any white spaces in between the chars spaces
    String[] letters = line.split(" ");
    //Now do something with your letters array 
}