public interface RecordRepository extends RecordRepositoryCustom, 
                                          CrudRepository<Record, Long> 
{
}

public interface RecordRepositoryCustom {
      // Custom method
      void massUpdateRecords(long... ids);
}

public class RecordRepositoryImpl implements RecordRepositoryCustom {
      @Override
      public void massUpdateRecords(long... ids) {
           //implement using em or querydsl
      }
}