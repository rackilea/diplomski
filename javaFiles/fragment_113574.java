try {
    i = Integer.parseInt(w);
    k = Integer.parseInt(x);

    file1.mkdirs();
    File file2 = File.createTempFile("open", ".txt", file1);
    PrintWriter pw = new PrintWriter(file2);

    pw.println("You Enter in Text Field 1:"+i);

    pw.println("You Enter in Text Field 2:"+k);
    pw.close();
}