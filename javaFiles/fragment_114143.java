import java.swing.text.MaskFormater;

try {
    MaskFormatter formatter = new MaskFormatter("+AA AAA AA AA AA");
    formatter.setValueContainsLiteralCharacters(false);
    System.err.println(formatter.valueToString("31987365414"));
} catch (ParseException e) {