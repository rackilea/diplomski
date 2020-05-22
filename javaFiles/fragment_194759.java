File f = new File(System.getProperty("user.home"), "fileName.txt");
try (Scanner stdln = new Scanner(f)) {
    String[] line = new String[238];
    int i = 0; // <-- outside the loop.
    while (stdln.hasNextLine()){
        line[i] = stdln.nextLine();
        i++;
    }
} catch (Exception e) {
    e.printStackTrace();
}