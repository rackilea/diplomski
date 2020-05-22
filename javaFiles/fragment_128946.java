private void insertSorted(String line) {
    // memFile is the ArrayList
    if (memFile.isEmpty()) {
        memFile.add(0, line);
    } else {
        int index = memFile.size() - 1;

        String[] tokens = line.trim().split(",");

        // column is the part I want to compare of the tokenized string
        while (index >= 0) {
            String lineList = memFile.get(index);

            String[] tokens1 = lineList.trim().split(",");

            if ((tokens1[column]).compareTo(tokens[column]) > 0) {
                index--;
            } else {
                break;
            }
        }
        memFile.add(index + 1, line);
        System.out.println("memFile is " + memFile);

    }
}