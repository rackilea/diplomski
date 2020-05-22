@Configuration
@ComponentScan(value = "com.test", excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =
        Primary.class))
public class RandomConfig {


}

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RandomConfig.class})
public class RandomTest {

    @Autowired
    ClassC c;

    @Test
    void when_then() {
        //prints "B"
        c.component.doSomething();
    }

}