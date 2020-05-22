public class Element {

private String elementName;

public Element(String elementName) {
    this.elementName = elementName;
}

@Override
public String toString() {
    return elementName;
}

}