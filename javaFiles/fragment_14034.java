@XmlRootElement(name = "suite")
public class Suite {

private String name;
private String verbose = "1";
private boolean parallel =false;

private List<Test> testCases = new ArrayList<Test>();
private List<Parameter> parameters = new ArrayList<Parameter>();

@XmlAttribute
public String getName() {
    return name;
}


public void setName(String name) {
    this.name = name;
}

@XmlAttribute
public String getVerbose() {
    return verbose;
}


public void setVerbose(String verbose) {
    this.verbose = verbose;
}

@XmlAttribute
public boolean isParallel() {
    return parallel;
}


public void setParallel(boolean parallel) {
    this.parallel = parallel;
}

@XmlElement(name = "test")
public List<Test> getTestCases() {
    return testCases;
}

public void setTestCases(List<Test> testCases) {
    this.testCases = testCases;
}

@XmlElement(name = "parameter")
public List<Parameter> getParameters() {
    return parameters;
}


public void setParameters(List<Parameter> parameters) {
    this.parameters = parameters;
}
}