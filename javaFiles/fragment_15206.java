import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GsonApp {

    public static void main(String[] args) {
        List<Class1> class1s = Arrays.asList(new Class1(), new Class1(), new Class1());
        List<Class2> class2s = Arrays.asList(new Class2(), new Class2(), new Class2());

        Pojo root = new Pojo();
        root.setClass1s(class1s);
        root.setClass2s(class2s);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(root);
        System.out.println(json);

        Pojo deserialised = gson.fromJson(json, Pojo.class);
        System.out.println(deserialised);
    }
}

class Pojo {

    private List<Class1> class1s;
    private List<Class2> class2s;

    // getters, setters, toString
}

class Class1 {

    private int id = ThreadLocalRandom.current().nextInt(100);

    // getters, setters, toString
}

class Class2 {

    private int age = ThreadLocalRandom.current().nextInt(70);
    private String name = RandomStringUtils.randomAlphanumeric(5);

    // getters, setters, toString
}