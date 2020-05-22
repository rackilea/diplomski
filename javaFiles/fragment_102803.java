public class Person {
    public name;

    public Person(String name) {
        this.name = name;
    }

    public boolean equals(Object o){
        if(o instanceof Person)
            if(this.name.equals(o.name))
                return true;
        return false;
    }
}