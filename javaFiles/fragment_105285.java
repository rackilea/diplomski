import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Item {

    List<Item> pool;

    public static void main(String[] args) {
        for (var m : Item.class.getMethods())
            System.out.println(m.getName() + " " +
                    Arrays.toString(m.getGenericParameterTypes()));
    }


    public <S extends Item> void withExtra1(S... extra) {
        Collections.addAll(pool, extra);
    }

    public void withExtra2(Item... extra) {
        Collections.addAll(pool, extra);
    }

}