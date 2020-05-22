public static void main(String[] args) throws IOException {

    final File eventFile = new File("event.txt");
    int count = 0;
    try (Scanner file = new Scanner(eventFile)) {
        while (file.hasNextLine()) {
            count++;
            file.nextLine();
        }
    }
    final ReadEventFile readEventFile = new ReadEventFile(count, eventFile);
    final String[] dataTable = readEventFile.openFile();
}