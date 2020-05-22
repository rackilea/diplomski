@XStreamAlias("root")
public class Root {
    private Node node;
}

@XStreamConverter(value = ToAttributedValueConverter.class, strings = {
        "text" })
public class Node {
    private String att;

    private String text;
}