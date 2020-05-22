try {
    PrintStream out = new PrintStream(new FileOutputStream(myfile));
    out.println("some text"); // it will write on File

    // OR if you setOut(PrintSrtream) then
    System.setOut(out);
    System.out.println("some text");// this will also write on file
} catch (IOException e) {
    out.println("Error:" + e.getMessage());
}