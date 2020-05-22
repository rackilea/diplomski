@Test
@Tag("red")
@Tag("production")
public void testWithColour() {...} 



@RunWith(JUnitPlatform.class)
@IncludeTags("red & !production")
public class JUnit5Example {
   //...
}