public class Reductor<A, T>
{
    private Reducer<A, T> worker;
    public Reductor<A, T>(Reducer<A, T> worker)
    {
        this.worker = worker;
    }

    public A fold(A rval, Iterator<T> itr)
    {
        while(itr.hasNext())
        {
            A rval = worker.foldIn(rval, itr.next());
        }
        return rval;
    }
}