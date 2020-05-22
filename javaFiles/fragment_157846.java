@Component
public class ServiceImpl implements Service{
private Set<Rules> rules = new HashSet<Rules>(); 

@Autowired
public ServiceImpl(Rules... args) {
    for (Rules r : args) {
        rules.add(r);
    } 
  }

}