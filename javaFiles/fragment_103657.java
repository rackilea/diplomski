@Component
public abstract class BaseX implements InterfaceX{

    @Autowired
    ListX listHolder;

    public void addToList(Long id){
        System.out.println("Here in BaseX");
        listHolder.getListLong().add(id);
    }

    @Override
    public void publish() {
        System.out.println("Print list values");
        listHolder.getListLong().stream().forEach(System.out::println);
    }
}