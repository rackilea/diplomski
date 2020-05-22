public interface FooDao<K, T>
{
   T find(Long id);
   List<T> find();
   K save(T instance);
   void delete(T instance);   
}