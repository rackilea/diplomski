@XmlRootElement
public class EAApplication {
private List<Application> applications;

public List<Application> getApplications() {
    return applications;
}

public void setApplications(List<Application> applications) {
    this.applications = applications;
}

@Override
public String toString() {
    return "EAApplication{" +
            "applications=" + applications +
            '}';
}
}