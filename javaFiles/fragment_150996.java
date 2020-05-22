import java.util.UUID;

private Map<Employee, String> serials;
private boolean showSerials;
// getter

@PostConstruct 
public void init() {
    serials = new HashMap<>();
    for(Employee employee : ...) {
        serials.put(employee, newSerial());
    }
}

public String getSerial(Employee employee) {
    return serials.get(employee);
}

public void buttonClick(ActionEvent event) {
    // other logic?
    showSerials = true;
}

private String newSerial() {
    return UUID.randomUUID().toString();
}