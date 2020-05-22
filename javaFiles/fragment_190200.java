public class Sorter implements Callable<List<String>> {

    private List<String> data;

public Sorter(List<String> input) {
    data = input;
}

@Override
public List<String> call() throws Exception {
    Collections.sort(data);
    return data;
}

 }