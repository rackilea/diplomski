final static int MAX = 15;
final static String itemWriterName = "itemWriter";
final static String newLineWriterName = "newLineWriter";

public static void main(String[] args) {

    Printer print = new Printer(MAX);

    Thread itemWriter = new Thread(new ItemWriter(print), itemWriterName);
    itemWriter.start();
    Thread newLineWriter = new Thread(new NewLineWriter(print), newLineWriterName);
    newLineWriter.start();
}