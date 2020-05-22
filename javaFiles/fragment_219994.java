@Entity
@NamedQuery(name = "Record.massUpdateRecords", query = "update records set someColumn=someValue where id in :ids")
@Table(name = "records")
public class Record {   
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private Long id;
      //rest of the entity...
}

public interface RecordRepository extends CrudRepository<Record, Long> 
{
      //this will use the namedquery
      void massUpdateRecords(@Param("ids") long... ids);
}