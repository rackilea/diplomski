public interface MyIF {
    /**
     * Javadoc for: query(Foo.InnerKey key)
     */
    public void query(Foo.InnerKey key); // Method to open call hierarchy
    /**
     * Javadoc for: query(Bar.InnerKey key)
     */
    public void query(Bar.InnerKey key);
}