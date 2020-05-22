import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Foo {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { { "1.txt" }, { "2.txt" } });
    }

    @Parameterized.Parameter // first data value (0) is default
    public /* NOT private */ String fileName;

    @Test
    public void test() {
        File i = readFile(fileName);
        File out = foo(i);
        assertEquals(FileUtils.readLines(expected), FileUtils.readLines(out));
    }
}