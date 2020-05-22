try {
    br = new BufferedReader( new FileReader(file_name));
    while((r = br.read()) != -1){
        char c = (char) r;
        System.out.print(c);
     }
} catch (FileNotFoundException e ){
    System.out.println("The file was not found.");
    System.exit(0);
} catch (IOException e){
    System.out.println("There was an error reading the file.");
    System.exit(0);
}