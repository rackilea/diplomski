File temp;
    try {
        temp = File.createTempFile("document", ".htm");
        BufferedWriter out = new BufferedWriter(new FileWriter(temp));
        out.write("hi !!!");
        out.close();

        System.out.println(temp.toURI().toString());

        java.awt.Desktop.getDesktop().browse(temp.toURI());
    } catch (IOException e) {
        e.printStackTrace();
    }