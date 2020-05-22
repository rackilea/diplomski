ArrayList<String> readLines(String fname) {

    File file = new File(fname);
    ArrayList<String> list = null;

    try {
        Scanner scanner = new Scanner(file);
        list = new ArrayList<String>();

        while (scanner.hasNext()) {
            String currentWord = scanner.next();
            if (!currentWord.isEmpty()) {
                list.add(currentWord);
            }
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    return list;
}