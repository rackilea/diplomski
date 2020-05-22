FileWriter fileStream = new FileWriter("my/path/for/file.txt");
BufferedWriter out = new BufferedWriter(fileStream);
while(fileScanner.hasNextLine()) {
    String next = fileScanner.nextLine();
    if(next.equals("\n")) 
       out.newLine();
    else 
       out.write(next);
    out.newLine();   
}
out.close();