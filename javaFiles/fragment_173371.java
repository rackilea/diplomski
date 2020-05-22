Reductor r = new Reductor<A, T>(new Reducer<A, T>()
{
    public A foldIn(A prev, T next)
    {
        A rval;
       //do stuff...
       return rval;
     }
 }

 A fold = r.fold(new A(), collection.getIterator());