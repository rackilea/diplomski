String code = "public class geo{public static void main(String[] args){System.out.println(\"geo\");}}";
    CodeFormatter cf = new DefaultCodeFormatter();

    TextEdit te = cf.format(CodeFormatter.K_UNKNOWN, code, 0,code.length(),0,null);
    IDocument dc = new Document(code);
    try {
        te.apply(dc);
        System.out.println(dc.get());
    } catch (MalformedTreeException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (BadLocationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }