import static java.util.Arrays.asList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryService {
    private Map<Class<?>, List<?>> repository = new HashMap<>();

    @SuppressWarnings("unchecked")
    public <T> List<T> put(Class<T> key, List<T> instances) {
        return (List<T>) repository.put(key, instances);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> get(Class<T> key) {
        return (List<T>) repository.get(key);
    }

    public static void main(String[] args) {
        RepositoryService repositoryService = new RepositoryService();
        repositoryService.put(Integer.class, asList(1, 2, 3));
        repositoryService.put(String.class, asList("A", "B", "C"));
        repositoryService.put(String.class, asList(1, 2, 3)); // doesn't compile
        List<Integer> integers = repositoryService.get(Integer.class);
        List<String> strings = repositoryService.get(String.class);
        List<Double> doubles = repositoryService.get(String.class); // doesn't compile
        System.out.println(integers);
        System.out.println(strings);
    }
}