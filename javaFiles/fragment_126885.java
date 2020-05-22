@Mapper
public interface BlogMapper {

    @Mapping(target = "userId", source = "user.id"),
    @Mapping(target = "commentedDate", source = "createdDate")
    BlogDto entityToDto(final Comment entity);

    default Timestamp map(Instant instant) {
        return instant == null ? null : Timestamp.from(instant);
    }
}