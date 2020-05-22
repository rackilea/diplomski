@Component
public class StringRoleConverter implements Converter<String, Role> {

    @Override
    public Role convert(String source) {
        Role role = new Role();
        int id = Integer.parseInt(source);
        role.setId(id);
        return role;
    }

    @Bean
    public ConversionService getConversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<>();
        converters.add(new StringRoleConverter());
        bean.setConverters(converters);
        return bean.getObject();
    }
}