public void addLine() {
       String lineseparator=System.getProperty("line.separator");
   // I'd suggest putting this as a class variable, so that it only gets called once rather
   // than
   // everytime you call the addLine() method
    try {
        FileWriter stream = new FileWriter(this.log, true);
        //If you don't add true as the second parameter, then your file gets rewritten
       // instead of appended to
        BufferedWriter out = new BufferedWriter(stream);

        out.write(lineseparator); //This substitutes your out.newline(); call

       out.close();
       stream.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}