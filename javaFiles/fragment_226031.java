try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("myfile.txt", true)))) {

     while(true) {
           out.println("more text");
     }
}catch (IOException e) {
     //exception handling left as an exercise for the reader
}