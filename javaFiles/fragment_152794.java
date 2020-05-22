try {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileNameOpen , true)));
    userNotes = kybd.nextLine()
    out.println(userNotes);
    out.close();
} catch (IOException e) {
    //oh noes!
}