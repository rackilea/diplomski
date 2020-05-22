public class PlayDocx4J {

    public static void main(String[] args) {

        try {
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
            wordMLPackage.getMainDocumentPart().addParagraphOfText("Hello Word!");
            wordMLPackage.save(new java.io.File("c:/test/helloword.docx"));
        } catch (Docx4JException e) {
            System.err.println("ERROR " + e.getMessage());
            e.printStackTrace();
        }
    }
}