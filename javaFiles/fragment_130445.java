import java.lang.reflect.Field;

class Block {

    private String name;
    public Block(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
class Blocks {

    public static Block wall = new Block("wall");
    public static Block corner = new Block("corner");
     ......
}

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field field = Blocks.class.getDeclaredField("wall"); // get the value from the args in real program
        Block b = (Block)field.get(null);
        System.out.println(b.getName());
    }
}