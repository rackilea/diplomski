public class Parser {

    private final ValuesProvider valuesProvider;
    private final ValuesMapper valuesMapper;
    private final ValuesConfiguration configuratrion;

    // all values injected.
    public Parser(ValuesProvider valuesProvider, ValuesMapper valuesMapper, ValuesConfiguration configuratrion) {
        this.valuesProvider = valuesProvider;
        this.valuesMapper = valuesMapper;
        this.configuratrion = configuratrion;
    }

    public Result parse(String parameterName) {
        List<Values> values = valuesProvider.getValues(parameterName);
        ...
        return valuesMapper.transformValues(values, configuration);
    }
 }