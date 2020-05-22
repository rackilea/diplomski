@Configuration
@Profile("mockEntityService")
public class EntityServiceMockProvider {

    @Bean
    @Primary
    public EntityService entityService() {
        EntityService mockedEntityService = Mockito.mock(EntityService.class);

        Entity entity= Mockito.mock(Entity.class);
        when(mockedEntityService.save(any(Entity.class)))
                .thenReturn(entity);

        return mockedEntityService ;
    }
}