public class Files {
    List<MyFile> list = new ArrayList<MyFile>();

    public Files() {
        super();
    }

    public boolean addFile(MyFile f) {
        return list.add(f);
    }
}

public class MyFile {
    public String name;
    public String version;
    public String size;
    public void setName(String name) {
        this.name = name;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public void setSize(String size) {
        this.size = size;
    }
    @Override
    public String toString() {
        return "MyFile [name=" + name + ", size=" + size + ", version="
                + version + "]";
    }

}

class ConditionalRule extends ObjectCreateRule {

    private boolean conditional = false;
    public ConditionalRule() throws ParserConfigurationException {
        super(MyFile.class);
    }

    @Override
    public void begin(String namespaceURI, String name, Attributes attributes)
            throws Exception {
        conditional = "ABC.EXE".equals(attributes.getValue("Name"));
        if(conditional) {
            Files files = (Files) digester.pop();
            MyFile f = new MyFile();
            files.addFile(f);
            digester.push(files);
            digester.push(f);
        }
    }

    @Override
    public void end() throws Exception {
        if(conditional) {
            digester.pop();
        }
    }

}
public class Snippet {

    @Test
    public void test() throws Exception {
        Digester d = new Digester();
        d.addObjectCreate("Files", Files.class);
        d.addRule("Files/File", new ConditionalRule());
        d.addSetProperties("Files/File",
                new String[]{"Name", "Version", "Size"}, new String[]{"name", "version", "size"});
        Object parse = d.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("digest.xml"));
        System.out.println(parse);
    }
}