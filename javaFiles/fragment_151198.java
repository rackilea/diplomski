BufferedReader in = null;
List<String> myList = new ArrayList<String>();
try {   
    in = new BufferedReader(new FileReader("myfile.txt"));
    String str;
    while ((str = in.readLine()) != null) {
        myList.add(str);
        //Or split your read string here as you wish.
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (in != null) {
        in.close();
    }
}