public class Element {

    private String element;

    public Element(String element) {
        setElement(element);
    }

    public String getElement() {
        return element; 
    }

    public void setElement(String element) {
        if (null == element) {
            throw new IllegalArgumentException("Element must not be null.");
        }
        this.element = element;
    }

    public boolean equals(Object other) {
        if (other instanceof Element) {
            Element otherElement = (Element) other;
            return element.equals(otherElement.element);
        }
        return false;
    }

    public int hashCode() {
        return element.hashCode();
    }
}