@Service
public class MyService implements service {
    @Autowired
    dao myDaoRepository;

    @Override
    public boolean save( Person person ){
        return this.myDaoRepository.save(person);
    }
    @Override
    public boolean delete(Person person){
        return  this.myDaoRepository.delete(person);
    }
}