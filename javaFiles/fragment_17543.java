public class doc<T> {

@XmlMixed
@XmlAnyElement(lax = true)
protected List<T> content;

public List<T> getContent() {
    if (content == null) {
        content = new ArrayList<T>();
    }
    return this.content;
}

public void setContent() {
    content = this.content;
}