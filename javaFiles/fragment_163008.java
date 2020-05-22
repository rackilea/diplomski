@XmlRootElement
public class Holder {
    private List<IFoo> things;

    public Holder() {
        things = new ArrayList<>();
    }

    @XmlElementWrapper
    @XmlAnyElement(lax=true)
    public List<IFoo> getThings() {
        return things;
    }

    public void addThing(IFoo thing) {
        things.add(thing);
    }
}