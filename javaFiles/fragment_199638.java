package ser_deser_test;

import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Elements implements Iterable<String> {
    // private List<String> elements; // Version A
    public List<String> elements;  // Version B

    public Elements() {
        super();
    }

    public Elements(List<String> elements) {
        super();
        this.elements = elements;
    }

    @Override
    public Iterator<String> iterator() {
        return elements.iterator();
    }

}