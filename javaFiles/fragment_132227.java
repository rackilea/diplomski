public interface Task<E> extends Serializable {
    Collection<? extends Task<? extends E>> splitTask (int partsNum);
    E mergeSolutions (Collection<? extends E> solutions);
    E solveTask ();
    E getSolution ();
    Integer getId ();
    void setId (Integer id);
}