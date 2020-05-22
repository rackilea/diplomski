import java.util.List;
import java.util.Arrays;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

@Test
public void bothValuesShouldBePresent() {
    List<Integer> itemValues = Arrays.asList(new Integer[]{ 0, 1, 2, 3 });
    Integer[] expected = { 0, 1 };
    assertThat(itemValues, hasItems(expected));
}