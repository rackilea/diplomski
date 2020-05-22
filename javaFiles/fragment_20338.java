public class LoggingRepositoryImpl<T extends IEntity, ID extends Serializable> implements LoggingRepositoryCustom<T, ID> {
      @Override
      public <S extends T> S save(S entity, AppUser author) {
           //impl
      }
}