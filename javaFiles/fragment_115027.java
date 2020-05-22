String searchTerm = args[0];
String fileName1 = args[1];
String fileName2 = args[2];
File file = new File(fileName1);

Scanner scan = new Scanner(file);
if (searchTerm != null) { // don't even start if searchTerm is null
    while (scan.hasNextLine()) {
        String scanned = scan.nextLine(); // you need to use scan.nextLine() like this
        if (scanned.contains(searchTerm)) { // check if scanned line contains the string you need
            try {
                BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileName2));
                bw.write(searchTerm);
                bw.close();
                break; // to stop looping when have already found the string
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
scan.close();