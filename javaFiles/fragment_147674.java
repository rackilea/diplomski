public interface Database<E> {

  public void store(Class<? extends E> clazz, E x);

  public void search(E x);

  public void remove(E x);

}