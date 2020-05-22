import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

public class SingletonTest {

  @Before
  public void resetSingleton() throws NoSuchFieldException, IllegalAccessException {
    Field instance = Singleton.class.getDeclaredField("singleton");
    instance.setAccessible(true);
    instance.set(null, null);
  }

  @Test
  public void singletonCanFindFile() throws Exception {
    final Path path = Paths.get("maybeIExist.txt");

    Files.createFile(path);
    final Singleton instance = Singleton.getInstance();
    assertThat(instance, notNullValue());
    Files.deleteIfExists(path);
  }

  @Test(expected = ExceptionInInitializerError.class)
  public void singletonCannotFindFile() throws Exception {
      final Singleton instance = Singleton.getInstance();
      fail("no exception thrown!");
  }
}