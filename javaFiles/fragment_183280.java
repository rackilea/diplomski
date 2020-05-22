@Bean  // needed for JSON conversion of bean responses
  @Primary
    public View jsonTemplate() {
      logger.info("Registered MappingJackson2JsonView");
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        Properties props = new Properties();
        props.put("order", 1);
        view.setAttributes(props);
        view.setPrettyPrint(true);          
        return view;
    }