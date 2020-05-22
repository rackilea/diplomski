public interface CoroutineProducer<T>
{
    public T Produce();
    public boolean isDone();
}

public interface CoroutineConsumer<T>
{
    public void Consume(T t);
}

public class CoroutineManager
{
    public static Execute<T>(CoroutineProducer<T> prod, CoroutineConsumer<T> con)
    {
        while(!prod.IsDone()) // really simple
        {
            T d = prod.Produce();
            con.Consume(d);
        }
    }
}