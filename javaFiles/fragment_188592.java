@Service
public class OperatorsService {

    @Value("${json.config.folder}")
    String jsonConfigFolder;

    List<ContextOperatorBean> operators = new ArrayList<>();

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        for (File jsonFile : getFilesInFolder(jsonConfigFolder)) {
            // deserialize contents of each file into an object of type
            ContextOperatorBean operator = jsonMapper.readValue(jsonFile, new TypeReference<List<ContextOperatorBean>>() {});
            operators.add(operator);
        }
    }

    public List<ContextOperatorBean> getMatchingOperators(String context) {
        return operators.stream().filter(operator -> checkIfMatches(operator, context)).collect(Collectors.toList());
    }

    private boolean checkIfMatches(ContextOperatorBean operator, String context) {
        // TODO implement
        return false;
    }

    private File[] getFilesInFolder(String path) {
        // TODO implement
        return null;
    }
}