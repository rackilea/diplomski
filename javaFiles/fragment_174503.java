import java.util.*;
class MapTest {

static class Dog {

    String name;

    public Dog(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if ((this == o)) {
            return true;
        } else if (((Dog)o).name.equals(this.name)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return name.length();
    }
}

static class Cat {
}

static enum Pets {

    DOG, CAT, HORSE
}
    public static void main(String[] args) {
        Map<Object, Object> m = new HashMap<Object, Object>();
        m.put("k1", new Dog("aiko"));
        m.put("k2", Pets.DOG);
        m.put(Pets.CAT, "CAT Key");
        Dog d1 = new Dog("Clover");
        m.put(d1, "Dog key");
        m.put(new Cat(), "Cat key");
        System.out.println(m.get("k1"));
        String k2 = "k2";
        System.out.println(m.get(k2));
        System.out.println(m.get(Pets.CAT));
        System.out.println(m.get(d1));
        System.out.println(m.get(new Cat()));
        // UNABLE TO UNDERSTAND BELOW PART OF CODE
        d1.name = "magnolia";
        System.out.println(m.get(d1)); // #1 
        d1.name = "clover";
        System.out.println(m.get(new Dog("clover"))); // #2
        d1.name = "arthur";
        System.out.println(m.get(new Dog("clover"))); // #3
    }
}