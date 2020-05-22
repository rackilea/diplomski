import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        Set<Integer> ints = newSet();

        SimpleModule module = new SimpleModule();
        module.addSerializer(Set.class, new SortedSetJsonSerializer());
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);

        System.out.println(mapper.writeValueAsString(new MyModel(ints)));
    }

    private static Set<Integer> newSet() {
        Set<Integer> ints = new HashSet<>();
        IntStream.range(10, 20).forEach(ints::add);

        return ints;
    }
}

class MyModel {
    private Set<Integer> integers;

    public MyModel(Set<Integer> integers) {
        this.integers = integers;
    }

    public Set<Integer> getIntegers() {
        return integers;
    }

    public void setIntegers(Set<Integer> integers) {
        this.integers = integers;
    }
}