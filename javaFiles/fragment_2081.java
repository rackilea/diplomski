import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonInheritanceTest {
public static void main(String[] args) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    C c = new C();
    c.classes = new ArrayList<Object>();
    c.classes.add(new A());
    c.classes.add(new B());
    System.out.println(gson.toJson(c));
}

public static class A {
    int stars;
}

public static class B extends A {
    int sunshines;
}

public static class C {
    List<Object> classes;
}
}