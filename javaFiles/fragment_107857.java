@Mapper
public interface MyMapper {

    C map(A source, @Context AutoIncrementorContext context);

    D map(B source, @Context AutoIncrementorContext context);
}