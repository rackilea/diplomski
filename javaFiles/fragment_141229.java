@Component(
 configurationPid = "my.component"
)
public class MyComponent implements ... {
   @Reference(target="(type=pdf)")
   Service myService;
}