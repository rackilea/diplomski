try {
    FileOutputStream fos = new FileOutputStream(fileDir);
    PrintStream ps = new PrintStream(fos);

    ...

} finally {
     fos.close();
     ps.close();
}