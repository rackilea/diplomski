package forum11966714;

import javax.xml.bind.annotation.*;

@XmlRootElement
class AdaptedFoo {
    private String name;
    private int age;

    public AdaptedFoo() {
    }

    public AdaptedFoo(Foo foo) {
        this.name = foo.getName();
        this.age = foo.getAge();
    }

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}