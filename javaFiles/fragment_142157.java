class BaseInfo {
    String baseName;
    @JsonProperty("salary")
    ArrayList<salary> salaries = new ArrayList<salary>();
}

class Salary {
    int id;
    @JsonProperty("info")
    EmplInfo emp;
}