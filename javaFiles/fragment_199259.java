public class NameWrapper {
    private final Name name;
    public NameWrapper(Name name) {
        this.name = name;
    }

    @Override
    public int hashcode() {
        return name.getMotherName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof NameWrapper)) return false;
        NameWrapper other = (NameWrapper) obj;
        return name.getMotherName().equals(other.name.getMotherName());
    }
}