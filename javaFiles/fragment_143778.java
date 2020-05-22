public class Version {
    private String version;
    private Boolean current;
    private Boolean compatible;
    private Date published;
    private String description;
    private List<Manifest> manifest; // Note the collection *and* object mapping
    private String jre;
    // Constructors, getters, setters
}

public class Manifest {
    private String name;
    private String checksum;
}