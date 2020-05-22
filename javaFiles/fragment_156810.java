public void write(String txt, OutputStream out) {
    PrintWriter printer = new PrintWriter(out);
    printer.print(txt);
    printer.flush();
    //it is very unpolite to close someone else's streams!
    //printer.close();
}