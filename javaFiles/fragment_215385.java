File f = new File("defaultMusicPath.txt");
try (BufferedWriter bw = 
        Files.newBufferedWriter(Paths.get(f.toURI()), StandardOpenOption.APPEND); 
        PrintWriter out = new PrintWriter(bw)) {
    out.println("Hello, world!");
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}