class FJSObject {

    String name;
    String namespace;
    String inherit;
    List<String> use;
    List<String> include;
    List<String> resemble;

    FJSObject() {
        use = new ArrayList<String>();
        include = new ArrayList<String>();
        resemble = new ArrayList<String>();
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("name      : ").append(name).append('\n');
        b.append("namespace : ").append(namespace).append('\n');
        b.append("inherit   : ").append(inherit).append('\n');
        b.append("resemble  : ").append(resemble).append('\n');
        b.append("use       : ").append(use).append('\n');
        b.append("include   : ").append(include);
        return b.toString();
    }
}