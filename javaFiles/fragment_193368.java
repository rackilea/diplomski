BufferedReader reader = null;
try {
    String line;
    reader = new BufferedReader(new FileReader("input.txt"));
    while ((line = reader.readLine()) != null) {
        myFunc (line);
    }
} catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} finally {
    if (reader!=null)
        try {
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}