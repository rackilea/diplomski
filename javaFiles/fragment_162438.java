BufferedReader in = null;
try {
    in = new BufferedReader(new FileReader("fileeditor.txt"));
    String read = null;
    while ((read = in.readLine()) != null) {
        String[] splited = read.split("\\s+");
        for (String part : splited) {
            System.out.println(part);
        }
    }
} catch (IOException e) {
    System.out.println("There was a problem: " + e);
    e.printStackTrace();
} finally {
    try {
        in.close();
    } catch (Exception e) {
    }
}