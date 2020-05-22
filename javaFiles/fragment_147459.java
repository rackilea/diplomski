public class Element {

    private String element;

    public Element() {

    }

    public Element(String element) {
        setE(element);
    }


    public String getElement() {
        return element; 
    }

    public void setElement(String element) {
        this.element = element;
    }

    public boolean equals(Object other) {
        if (other instanceof Element) {
            Element otherElement = (Element) other;
            if (null == element) {
                return otherElement.element == null;
            }
            return element.equals(otherElement.element);
        }
        return false;
    }

    public int hashCode() {
        if (null == element) {
            return -7;
        }
        return element.hashCode();
    }
}