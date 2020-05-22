public class BaseServiceImpl<T, ID extends Object&Serializable>
      implements BaseService<T, ID> {
    @Override
    public T findOne(ID id) {
        return null;
    }
}