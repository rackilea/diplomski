public void writeToFile(String fileName) throws FileNotFoundException {
    PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
    for (T item : myArray) {
        if (item instanceof Character) { ... }
        else if (item instanceof Integer) { pw.println(Integer.toString(item)) }
        else if (item instanceof ArrayList<String>) { 
            for(String str: item) {
                pw.write(str);
            }
        }
       .
       .
       .
    }
        pw.close();
}