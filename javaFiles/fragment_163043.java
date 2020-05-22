private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
>       
>       private final Lock readLock = readWriteLock.readLock();
>     
>       private final Lock writeLock = readWriteLock.writeLock();
>     
>       private final List<E> list = new ArrayList<>();
>       
>       public void set(E o)
>       {
>           writeLock.lock();
>           try
>           {
>               list.add(o);
>               System.out.println("Adding element by thread"+Thread.currentThread().getName());
>               }
>           finally
>           {
>               writeLock.unlock();
>           }
>       }