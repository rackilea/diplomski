public static int search(String name) {
    String path = "C:\\Users\\Charbel\\Desktop\\Dictionary.txt";
    int countL = 0;
    String line;

    BufferedReader bf = null;
    try {
        bf = new BufferedReader(new FileReader(path));

        while (( line = bf.readLine()) != null)
        {
            int indexfound = line.indexOf(name);

            if (indexfound == 0) {
                return countL;
            }
            countL++;
        }
    }
    catch (IOException e) {
        System.out.println("IO Error Occurred: " + e.toString());
    }
    finally {
        if(bf != null) {
            try {
                bf.close();
            }
            catch(IOException ignored) {}
        }
    }
    return -1;
}