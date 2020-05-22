public static void main(String[] args) {
    Element root = new Element("root");  
    Element fraction = new Element("Fraction");
    fraction.addAttribute(new Attribute("hash", "108e898f"));
    root.appendChild(fraction);
    Element integer = new Element("Integer");
    integer.addAttribute(new Attribute("hash", "19498483"));
    root.appendChild(integer);
    Document doc = new Document(root);
    try {
        Serializer serializer = new Serializer(System.out, "ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(64);
        serializer.write(doc);  
    } catch (IOException ex) {
        System.err.println(ex); 
    }  
}