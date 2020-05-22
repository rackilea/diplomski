public enum PDF { it;
    static String contentType = "application/pdf";
    static String fileEnding = "pdf";        
}
static void myMethod1(PDF pdf) {
   System.out.println(pdf.fileEnding);
}  

public static void main(String[] args ) {
    myMethod1(PDF.it); // Works fine! Somewhat verbose though because of the "it" keyword. Not 100% ideal!      
}