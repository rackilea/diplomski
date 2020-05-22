public class SaveToFile extends ImageAnnotationInstance {
    public static void main(String[] args){
        ImageAnnotation imageAnnotation = new ImageAnnotation();
        PathXSD pathXSD = new PathXSD();
        AnnotationBuilder.saveToFile (imageAnnotation, "./test.xml", pathXSD);
        System.out.println(AnnotationBuilder.getAimXMLsaveResult());
    }   
}