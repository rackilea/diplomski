@Configuration
public final class Mappers{

    private final FooMapper fooMapper;
    private final FeeMapper feeMapper;

    @Autowired
    public Mappers(FooMapper fooMapper, FeeMapper feeMapper){
        this.fooMapper = fooMapper;
        this.feeMapper = feeMapper;
    }

    @Bean
    public RevMapper<Foo, FooDto> fooRevMapper(){
        return new RevMapper(fooMapper);
    }

    @Bean
    public RevMapper<Fee, FeeDto> feeRevMapper(){
        return new RevMapper(feeMapper);
    }
}