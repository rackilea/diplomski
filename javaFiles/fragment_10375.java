@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitWebConfig(locations = { "classpath:service.xml", "classpath:data.xml" })
@Tag("1")
public @interface TransactionalIntegrationTest {
}