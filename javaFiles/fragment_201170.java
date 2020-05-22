@Primary
@Bean
public ObjectMapper objectMapper(){
   return new Jackson2ObjectMapperBuilder()
                .build();
}

@Bean("customMapper")
public ObjectMapper customMapper(){
  ObjectMapper customMapper = new Jackson2ObjectMapperBuilder().build();
     mapper.<your customization , filters, providers etc;>
     return mapper;
}