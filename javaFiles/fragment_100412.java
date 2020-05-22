public static void main(String[] args){
    String filePath = "the path to your text file";

    List<Element> elements;
    try {
        elements = ElementsFileReader.read(filePath);
    } catch(IOException e){
        System.err.println("Something gone wrong reading elements file...");
        e.printStackTrace();
        return;
    }

    for(Element element : elements){
        System.out.println(element);
        // do your stuff
    }
}