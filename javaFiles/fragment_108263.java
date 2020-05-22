public static void stringToDom(String xmlSource) 
        throws IOException {
    java.io.FileWriter fw = new java.io.FileWriter("my-file.xml");
    fw.write(xmlSource);
    fw.close();
}