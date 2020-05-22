try {
    BufferedReader buffread = new BufferedReader (new FileReader("file.txt"));
} catch (FileNotFoundException ex) {
    // Do something with 'ex'
} catch (IOException ex2) {
    // Do something with 'ex2'
}