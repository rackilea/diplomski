@RequestMapping(...)
public MappingJacksonValue getUserEntities(...) 
    Page<UserEntity> entities = service.findAll();
    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(entities);
    FilterProvider filters = new SimpleFilterProvider()
                .addFilter("UserEntity", SimpleBeanPropertyFilter
                        .filterOutAllExcept("fieldName"));
    mappingJacksonValue.setFilters(filters);
    return mappingJacksonValue;
}