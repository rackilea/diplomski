ArrayList<String[]> arrayList = new ArrayList<>();
try {
    // open input stream text_file for reading purpose.
    while ((thisLine = BufferedRdr.readLine()) != null) {
        if (!thisLine.isEmpty()) {
            String[] parts = thisLine.split(" ");
            arrayList.add(parts);
        }
    }
} catch (Exception e) {
    e.printStackTrace();
}