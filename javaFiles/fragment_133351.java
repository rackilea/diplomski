@Bean
public Jackson2ObjectMapperBuilderCustomizer customizer()
{
    return new Jackson2ObjectMapperBuilderCustomizer()
    {
        @Override
        public void customize(Jackson2ObjectMapperBuilder builder)
        {
            builder.serializerByType(CustomPojo.class, 
                                     new CustomSerializator<CustomPojo>());
            //affects to all dates in all pojos (I hope :) )
            builder.indentOutput(true).dateFormat(new SimpleDateFormat
                                                  ("yyyy-MM-dd'T'HH:mm:ssXXX"));

        }
    };
}