import java.util.HashMap;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class MapParser {

    public static void main(String[] args) {

        XStream xstream = new XStream(new DomDriver());
        xstream.alias("map", Map.class);
        xstream.addImplicitCollection(Map.class, "parents");
        xstream.alias("parent", Parent.class);
        xstream.useAttributeFor(Parent.class, "key");
        xstream.alias("child", Child.class);
        xstream.useAttributeFor(Child.class, "key");

        Map map = (Map) xstream
                .fromXML("<map><parent key='p1'><child key='c1'><value>value1</value></child></parent><parent key='p2'><child key='c2'><value>value1</value></child></parent></map>");

        System.out.println(xstream.toXML(map));

        java.util.Map result = new HashMap();
        for (Parent parent : map.getParents()) {

            Child child = parent.getChild();
            String key = parent.getKey() + "." + child.getKey();
            result.put(key, child.getValue());
            System.out.println(key + "=" + child.getValue());
        }
    }
}


import java.util.ArrayList;
import java.util.List;

public class Map {

    private List<Parent> parents = new ArrayList<Parent>();

    public void addParent(Parent parent) {
        parents.add(parent);
    }

    public List<Parent> getParents() {
        return this.parents;
    }
}

public class Parent {

    private String key;
    private Child child;

    public Parent(String key) {
        this.key = key;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}


public class Child {

    private String key;
    private String value;

    public Child(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}