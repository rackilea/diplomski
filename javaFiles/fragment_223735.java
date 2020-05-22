import java.util.ArrayList;
import java.util.List;

public class County {
    private String name;
    private List<String> zipCodes = new ArrayList<>();

    // constructor that takes county name
    public County(String name) {
        this.name = name;
    }

    public void addZipCode(String code) {
        zipCodes.add(code);
    }

    // ..... more code