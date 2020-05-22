ObjectMapper mapper = new ObjectMapper();

    // Field that not to be serialised. 
    SimpleBeanPropertyFilter firstFilter = SimpleBeanPropertyFilter.serializeAllExcept("anotherName");
     SimpleBeanPropertyFilter secondFilter = SimpleBeanPropertyFilter.serializeAllExcept("secondName");

    FilterProvider filters = new SimpleFilterProvider().addFilter("firstFilter", firstFilter).addFilter("secondFilter", secondFilter);

    MyDtoWithFilter dtoObject = new MyDtoWithFilter();
    String dtoAsString = mapper.writer(filters).writeValueAsString(dtoObject);