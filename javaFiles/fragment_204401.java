public MenuDTO map(MenuEntity entity) {
        ModelMapper mapper = new ModelMapper();
        mapper.createTypeMap(TastingMenuEntity.class, MenuDTO.class)
        .setConverter(mappingContext -> mapper.map(mappingContext.getSource(), TastingMenuDTO.class));

        mapper.createTypeMap(SimpleMenuEntity.class, MenuDTO.class)
        .setConverter(mappingContext -> mapper.map(mappingContext.getSource(), SimpleMenuDTO.class));

        return mapper.map(entity, MenuDTO.class);
    }