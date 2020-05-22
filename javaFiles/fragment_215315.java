public class Order {
    String name;

    public Order(String n) {
        name = n;
    }

    // setter and getters of name
    @Override
    public int hashCode() {
        int h = 0;
        int len = name.length();
        for (int i = 0; i < len; i++)
            h = 31 * h + name.charAt(i);
        return h;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        else if(this.hashCode() == obj.hashCode())
            return true;
        return false;
    }
}