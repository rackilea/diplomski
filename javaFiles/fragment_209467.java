import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ItemTest {
    @Test
    public void testOutputToFile() throws IOException {
        List<Item> itemList = new ArrayList<Item>();
        StringWriter sw = new StringWriter();
        BufferedWriter bw = new BufferedWriter(sw);

        itemList.add(new Item("Item1","Item2")); 
        itemList.add(new Item("Item3","Item4")); 

        Item.write(bw, itemList);

        String string = sw.toString();
        String expectedString = "Item1,Item2" + System.lineSeparator() + "Item3,Item4" + System.lineSeparator();

        assertEquals(expectedString, string);
    }
}