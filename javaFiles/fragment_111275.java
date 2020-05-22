public static void main(String[] args){

    try{
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Templates t = tFactory.newTemplates(new File(... stylesheet file ....));
        Source doc = new StreamSource(
          new File("/Users/youruser/code/Exercises/file.xml"));
        t.newTransformer().transform(doc, new StreamResult(System.out));
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}