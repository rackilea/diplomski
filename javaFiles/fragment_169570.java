public interface TaggedInterface {
    void foo();
}

public interface XMLElementInterface {
    void bar();
}

public class Tagged implements TaggedInterface {
    // ...
}

public class XMLElement implements XMLElementInterface {
    // ...
}

public class TaggedXmlElement implements TaggedInterface, XMLElementInterface {
    private TaggedInterface tagged;
    private XMLElementInterface xmlElement;

    public TaggedXmlElement(TaggedInterface tagged, XMLElementInterface xmlElement) {
        this.tagged = tagged;
        this.xmlElement = xmlElement;
    }

    public void foo() {
        this.tagged.foo();
    }

    public void bar() {
        this.xmlElement.bar();
    }

    public static void main(String[] args) {
        TaggedXmlElement t = new TaggedXmlElement(new Tagged(), new XMLElement());
        t.foo();
        t.bar();
    }
}