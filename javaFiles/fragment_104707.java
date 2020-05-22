@Component("PropertyMapper")
public class PropertyMapper {

@Autowired
ApplicationContext context;
@Autowired
List<List<String>> split;

public List<List<String>> splitValues(final String beanname) {
((Properties) this.context.getBean(beanname)).values().forEach(v -> {
final List<String> paths = Arrays.asList(((String) v).split(","));
paths.forEach(p -> paths.set(paths.indexOf(p), p.trim()));
this.split.add(paths);
});
return this.split;
}