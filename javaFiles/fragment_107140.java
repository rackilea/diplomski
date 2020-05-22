public class MapperFacade {
    private MapperFactory mapperFactory = MapperFactory.getInstance();

    public <Entity, DTO> DTO entityToDTO(Entity entity, Class<DTO> dtoClass) {
        Mapper<Entity, DTO> mapper = mapperFactory.getMapper(entity.getClass());
        return mapper.mapReverse(entity);
    }

    public <Entity, DTO> Entity dtoToEntity(DTO dto, Class<Entity> entityClass) {
        Mapper<Entity, DTO> mapper = mapperFactory.getMapper(dto.getClass());
        return mapper.map(dto);
    }
}