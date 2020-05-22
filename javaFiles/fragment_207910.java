import java.util.Arrays;
import java.util.Collections;
import java.util.List;

    public class Main {

        public static void main(String[] args) {

            List<Item> list = Arrays.asList(new Item(3), new Item(6), new Item(-4));

            Collections.sort(list);

            for (Item item : list) {
                System.out.println(item.getNumber());
            }
        }

    }