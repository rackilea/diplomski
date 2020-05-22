@Component
public class BatchProcessor {

    //Spring will ensure this entityManager is the same as the one that start transaction due to  @Transactional
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private FooRepository fooRepository;

    @Transactional
    public void startProcess(){

        processBatch(1,100);
        processBatch(101,200);
        processBatch(201,300);
        //blablabla

    }

    private void processBatch(int fromFooId , int toFooId){
        List<Foo> foos =  fooRepository.findFooIdBetween(fromFooId, toFooId);
        for(Foo foo :foos){
            //process a foo
        }

        /*****************************
        The reason to flush is send the update SQL to DB . 
        Otherwise ,the update will lost if we clear the entity manager 
        afterward.
        ******************************/
        em.flush();
        em.clear();
    }
}