@Component
public class SuchBean {
     private MuchDependency muchDependency;

     @Autowired
     public SuchBean(MuchDependency muchDependency){
         this.muchDependency = muchDependency;
     }

}