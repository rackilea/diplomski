@Autowired
SessionFactory sessionFactory

protected Session getSession(){
    return sessionFactory.getCurrentSession();
}

public Record findById( long id ){
    return ( Record ) getSession().get( Record.class, id );
}

public Collection<Record> findByMultipleIds( Set<Long> ids ){
    Collection<Record> records = new ArrayList<Record>();
    List<Future<Record>> futures = new ArrayList<Future<Record>>();
    ExecutorService pool = Executors.newFixedThreadPool( 10 ); 
    for( int i = 0; i < ids.size(); ++i ){
        futures.add( pool.submit( new MyCallable<Record>( ids.get( i ))));
    }
    for( Future<Record> future : futures ) {
        records.add( future.get() );
    }
    return records;
}

private class TemporarySession implements AutoCloseable{
    private Session session;
    protected TemporarySession(){
        create();
    }
    protected Session getSession(){
        return session;
    }
    protected void create(){
        session = sessionFactory.openSession();
    }
    protected void destroy(){
        session.flush();
        session.clear();
        session.close();
    }
    @Override
    public void close(){
        destroy();
    }
}

private class MyCallable<Record> implements Callable<Record>{
    private long id;
    private MyCallable( long id ){
        this.id = id;
    }
    @Override   
    public Record call(){
        try( TemporarySession tSession = new TemporarySession() ){
            return tSession.get( Record.class, id );
        }
    }   
}