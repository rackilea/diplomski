import java.util.ArrayList;
import java.util.List;

public class County {
    private String name;
    private List<ZipCode> zipCodes = new ArrayList<>();

    // constructor that takes county name
    public County(String name) {
        this.name = name;
    }

    public void addZipCode(ZipCode code) {
        zipCodes.add(code);
    }

    // getters, setters, a decent toString method override...