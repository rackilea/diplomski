@ContextConfiguration(classes=BaseConfig.class)
 public class BaseTest {
     // ...
 }

 @ContextConfiguration(classes=ExtendedConfig.class)
 public class ExtendedTest extends BaseTest {
     // ...
 }