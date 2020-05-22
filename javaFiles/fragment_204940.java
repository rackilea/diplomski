@RunWith(Theories.class)
public class EntitiesAreValidTest {

    @DataPoints
    public static Class<?>[] entities = new Class[] {
        SimpleEntity.class,
        SimpleEntityWithTransientField.class,
        TwoFieldEntity.class
    };

    @Theory
    public void classHasValidConfiguration(Class<?> entityClass) {

        new AnnotationConfiguration().addAnnotatedClass(entityClass).buildMappings();
    }
}