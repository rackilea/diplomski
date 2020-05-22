public class Run {
    public static void main(String[] args) {
        XStream xs = new XStream(new DomDriver());
        xs.processAnnotations(new Class[] { Field.class, Container.class });
        Container c = new Container();
        c.addField("boo", 1,2, "desc");
        c.addField("boo", 1,2, "desc");
        String serialized = xs.toXML(c);
        System.out.println(serialized);

        // deserialize
        Container newContainer = (Container) xs.fromXML(serialized);
        if (newContainer.fields.size() != 2) {
            System.out.println("Not deserialized as expected...");
        }

        // if you don't want "container"
        xs.alias("mylist", List.class);
        System.out.println(xs.toXML(c.fields));
    }
}