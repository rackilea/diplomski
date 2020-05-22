public class GeneralManager<T extends PersistentDao, E extends Persistent>  {
    private T dao;
    public void setDao(T dao) {
        this.dao = dao;
    }
    ...
}