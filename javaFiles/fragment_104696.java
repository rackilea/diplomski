@Parameters
public static Collection<Object[]> data() throws IOException {
    List<Object[]> data = new ArrayList<>();
    // replace getClass() with <nameofclass>.class
    try(InputStream in = this.getClass().getResourceAsStream()) { 
        //parse body here
        data.add(new Object[]{attribute, value});
    }
    return data;
}