public class BaseServiceImpl<T,ID extends Serializable> implements BaseService<T, ID> {
    @Override
    public T findOne(ID id) {
        return null;
    }
}