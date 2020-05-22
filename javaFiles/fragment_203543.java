public void dontWriteSomtimes(So so) {
    ObjectMapper mapper = new ObjectMapper();
    FilterProvider filters = new SimpleFilterProvider()  
      .addFilter("filter properties by name", SimpleBeanPropertyFilter.serializeAllExcept("somtimeIgnore"));  
    ObjectWriter writer = mapper.writer(filters);  
    try {
        System.out.println(writer.writeValueAsString(so));
    } catch (Exception e) {
        e.printStackTrace();
    }
}