package so.q48042638;

import java.util.List;

public class Car {
    private String name;
    private List<List<String>> colors;

    public Car(String name) {
        this.name = name;
    }

    public List<List<String>> getColors() {
        return colors;
    }

    public void setColors(List<List<String>> colors) {
        this.colors = colors;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name : " + name + " colors: " + colors;
    }
}