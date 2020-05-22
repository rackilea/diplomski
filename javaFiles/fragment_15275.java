private Map<String, String> branchMap;

@PostConstruct
public void init() {
    branchMap = new LinkedHashMap<String, String>();
    branchMap.put("branch label 1", "branch value 1");
    branchMap.put("branch label 2", "branch value 2");
    branchMap.put("branch label 3", "branch value 3");
}