public void save() {
    String[] array2 = listForSave();
    PrintWriter printer = null;

      try {
          printer = new PrintWriter(file);
          printer.println(array2.length);
            for (String o : array2) {
                printer.println(o);
            }
            printer.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }

}
public void open(){
    try{

    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    StringBuffer stringBuffer = new StringBuffer();
    int arraySize = Integer.parseInt(stringBuffer.readLine());
    Object[] array = new Object[arraySize];
    int index = 0;
    String line;
    while ((line = bufferedReader.readLine()) != null) {
        // split line and create Object (see above)
        Object o = // ...
        array[index++] = o;
    }
    //...
    }catch ( IOException e ) {
        e.printStackTrace();
    }
    //...
}