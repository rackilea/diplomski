public class Tool {
    final String name;
    final double weight;

    public Tool(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
}

public class Drawer {
    final String name;
    final List<Tool> tools;

    public Drawer(String name) {
        this.name = name;
        this.tools = new ArrayList<>();
    }
}

public class Toolbox {
    final String name;
    final List<Drawer> drawers;

    public Toolbox(String name) {
        this.name = name;
        this.drawers = new ArrayList<>();
    }

    public void addDrawers(String... names) {
        for (String name : names) {
            drawers.add(new Drawer(name));
        }
    }
}