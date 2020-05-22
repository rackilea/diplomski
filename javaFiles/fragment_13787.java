@Override
public List<Person> Read() {
    Constructor c = new Constructor(Root.class);
    TypeDescription td = new TypeDescription(Root.class);
    td.putListPropertyType("persons", Person.class);
    c.addTypeDescription(td);
    Yaml yaml = new Yaml(c);

    try  {
        FileReader fr = new FileReader("d:\\Person.yml");
        Root r = yaml.loadAs(fr, Root.class);
        fr.close();
        return r.persons;
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return Collections.<Person>emptyList();
}