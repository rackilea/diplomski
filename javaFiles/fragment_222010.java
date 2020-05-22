package persistence;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, K extends Serializable>
{
    T find(K id);
    List<T> find();
    List<T> find(T example);
    List<T> find(String queryName, String [] paramNames, Object [] bindValues);

    K save(T instance);
    void update(T instance);
    void delete(T instance);
}