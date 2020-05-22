public class Item implements Comparable<Item> {

    public String id;
    public String desc;

    public String getId() {
        return id;
    }

    @Override
    public int compareTo(Item o) {
        return getId().compareTo(o.getId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Item)) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}