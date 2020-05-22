import java.util.List;

public class Main
{
    private static final InputFileParser inputFileParser = new InputFileParser();
    private static final EntryNumberExtractor extractor = new EntryNumberExtractor();
    private static final String FILENAME = "input-file.txt";

    public static void main(String... args) 
    {
        List<Entry> entries = inputFileParser.parse(FILENAME);
        List<Integer> extractedIntegers = extractor.extract(entries);

        System.out.println("Entries: ");
        prettyPrintListItems(entries);

        System.out.println();

        System.out.println("Entry numbers: ");
        prettyPrintListItems(extractedIntegers);
    }

    private static <T> void prettyPrintListItems(List<T> list)
    {
        for (T item : list)
        {
            System.out.println(item);
        }
    }
}