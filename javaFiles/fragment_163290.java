public class Sand implements Cloneable {
    public Object clone() throws CloneNotSupportedException {
        Sand copy = (Sand) super.clone();
        // Sand specific copying done here
        return copy;
    }
}