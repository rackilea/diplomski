ObjectMapper mapper = new ObjectMapper();
    mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    MyDtoAccessLevel dtoObject = new MyDtoAccessLevel();

    String dtoAsString = mapper.writeValueAsString(Arrays.asList(dtoObject));
    System.out.println(dtoAsString);