public class SingletonText {
private static CompositeText text;

public SingletonText() {
}

public static CompositeText getInstance() {
    if (text ==null) {
        text = new CompositeText(new TextReader("text/text.txt").readFile());
    }
    return text;
}
}