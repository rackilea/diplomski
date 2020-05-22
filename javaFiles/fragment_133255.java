try {
    FileWriter fw = new FileWriter("ReglasDelTablero.txt");
    PrintWriter pw = new PrintWriter(fw);

    //...
} catch (IOException e) {
    //...
} finally {
    pw.close();
    fw.close();
}