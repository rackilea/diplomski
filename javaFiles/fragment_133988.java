public class GuiceModule extends EndpointsModule {
    @Override
    public void configureServlets() {
        super.configureServlets();
        bind(UsuariosEndpoint.class).toInstance(new UsuariosEndpoint());
        bind(ServiciosEndpoint.class).toInstance(new ServiciosEndpoint());
        configureEndpoints("/_ah/api/*", ImmutableList.of(UsuariosEndpoint.class, 
                ServiciosEndpoint.class));
        bind(ComunidadesAutonomasService.class).to(ComunidadesAutonomasServiceImpl.class);
        bind(CategoriasService.class).to(CategoriasServiceImpl.class);
    }

    @Provides
    @Singleton
    public ModelMapper provideModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setCollectionsMergeEnabled(false);
        modelMapper.addConverter(new LocalDateToString());
        modelMapper.addConverter(new StringToLocalDate());
        modelMapper.addConverter(new LocalDateTimeToString());
        modelMapper.addConverter(new StringToLocalDateTime());

        return modelMapper;
    }
}