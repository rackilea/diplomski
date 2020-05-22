@Component
public class SuchBean {
     // this dep doesn't have a setter, so the CDI will use reflection to set it
     @Autowired private MuchDependencyWithReflection muchDependencyWithReflection;
     // this dep has a setter so the CDI will use the setter to set it
     @Autowired private MuchDependencyWithSetter muchDependencyWithSetter;

     public void setMuchDependencyWithSetter(MuchDependencyWithSetter muchDependencyWithSetter){
         this.muchDependencyWithSetter = muchDependencyWithSetter;
     }
}