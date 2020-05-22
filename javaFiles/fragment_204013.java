ModelMapper modelMapper = new ModelMapper();
Converter<Set, Boolean> SET_TO_BOOLEAN_CONVERTER =
        mappingContext -> !mappingContext.getSource().isEmpty();

modelMapper.createTypeMap(MyEntity.class, MyEntityDto.class)
    .addMappings(mappings -> mappings.using(SET_TO_BOOLEAN_CONVERTER)
                            .map(MyEntity::getFoos, MyEntityDto::setHasFoos));