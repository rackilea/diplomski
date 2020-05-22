@ContextConfiguration(locations = "classpath:context.xml")
@Transactional
public class FooTest {
  //...
}

@ContextConfiguration(locations = "classpath:context.xml")
@Transactional
public class BarTest {
  //...
}