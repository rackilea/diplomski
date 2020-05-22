@Component
public class StringToCriteriaConverter implements Converter<String, BaseCriteria> {

    @Autowired
    private CriteriaService service;

    //source is the ID passed by the page
    public BaseCriteria convert(String source) {
        // lookup and return item with corresponding ID from the database
    }
}