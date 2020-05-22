@XmlRootElement(name = "Resource")
public class Resource {
    @XmlElement(required = true)
    protected Collection<TItem> item;
    ....
    public Collection<TItem> getItem() {
        if (item == null) {
            item = new TreeSet<TItem>(cmp);//cmp is an instance of Comparator<TItem>
        }
    return this.item;
}