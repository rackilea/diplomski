public interface Dao<E> implements Serializable{

        public E find(int id);

        public void insert(E entity);

        public void update(E entity);

        public void delete(int id);
    }