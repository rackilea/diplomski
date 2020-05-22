public class TextProcessorImpl implements TextProcessor {

private String filename;
private ArrayList<String> lst = new ArrayList<String>(); 

public TextProcessorImpl(String filename) {
    this.filename = filename;
    String current;
    Scanner scan = TextReader.openFile(filename);
    ...