import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.testng.TestNG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sample {

  @Test
  public void versionConfirm() {
    String file = TestNG.class.getProtectionDomain().getCodeSource().getLocation().getFile();
    String actualVersion = new File(file).getParentFile().getName();
    assertEquals(actualVersion, "7.0.0-beta7");
  }

  @DataProvider(name = "testDataProvider")
  public static Object[][] testDataProvider(Method method) {
    Map<String, String> params = new HashMap<>(2);
    params.put("a", "foo");
    params.put("b", "bar");
    params.put(method.getName(), Integer.toString(params.hashCode()));
    return new Object[][] {{params}};
  }

  @Test(dataProvider = "testDataProvider")
  public void testCase01(Map<String, String> params) {
    params.put("a", "oof");
    assertEquals(params.get("a"), "oof");
    assertTrue(params.containsKey("testCase01"));
    assertFalse(params.containsKey("testCase02"));
  }

  @Test(dataProvider = "testDataProvider", dependsOnMethods = "testCase01")
  public void testCase02(Map<String, String> params) {
    assertEquals(params.get("a"), "foo"); // this won't pass
    assertFalse(params.containsKey("testCase01"));
    assertTrue(params.containsKey("testCase02"));
  }
}