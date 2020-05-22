@Bean
    public Jackson2JsonMessageConverter listnerMessageConverter(){
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        DefaultClassMapper classMapper = new DefaultClassMapper();

        Map<String, Class<?>> idClassMapping = new HashMap<String, Class<?>>();
        idClassMapping.put(
                "com.rabbitmq.example.AlunoModel", AlunoModel.class);
        idClassMapping.put(
                "com.rabbitmq.example.UsuarioModel", UsuarioModel.class);
        classMapper.setIdClassMapping(idClassMapping);
        converter.setClassMapper(classMapper);

        return converter;
    }

    @Bean
    public RabbitTemplate rabbitTemplate (final ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(listnerMessageConverter());
        return rabbitTemplate;
    }