@Component
public class SpringMapParent {
    @Resource
    @Qualifier("theMap")
    private Map<String, Object> theMap;

    ...
}