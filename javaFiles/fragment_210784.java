public class FormattingExamples {
    public static void main(String []args) {
        Formatter<Number,String> formatter = new NumberInWordsFormatter();
        String numberInWords = formatter.format(100);
        System.out.println(numberInWords);
    }
}