@Repository
public interface DRepository extends CrudRepository<D, Long> {

    @Query("select d from D d left outer join d.parameter op order by op.rank desc")
    List<D> getDs();

}