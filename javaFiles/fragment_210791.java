public class JenkinsServer {
    private List<String> assignedLabels;

    @Expose
    private String url;

    @Expose
    private String mode;

    @Expose
    private String nodeName;

    @Expose
    private String nodeDescription;

    @Expose
    private String description;

    @Expose
    private boolean useSecurity;

    @Expose
    private boolean quietingDown;

    @Expose
    private JenkinsServerView primaryView;

    @Expose
    private List<JenkinsServerView> views;

    @Expose
    private List<JenkinsJob> jobs;

    // getters & setters methods
}