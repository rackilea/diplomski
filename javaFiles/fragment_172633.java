long time1 = System.currentTimeMillis();
// some code for function 1
long time2 = System.currentTimeMillis();

try {
    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File("log.txt"),true));
    osw.write("function1,"+(time2 - time1)+"\n");
    osw.close();
} catch (FileNotFoundException ex) {
    ex.printStackTrace();
} catch (IOException ex) {
    ex.printStackTrace();
}