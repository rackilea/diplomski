@Entity
public class Reporting {

    // You said you just want a single fileName as primary key
    @Id
    @Column(name="file_name", nullable=false)
    private String fileName;

    // You said you still want to have the whole ReportingFile object
    @Embedded
    private ReportingFile reportingFile;

    // Your workaround goes here
    @CollectionOfElements(fetch=FetchType.EAGER)
    @JoinTable(
        name="t_reports",
        joinColumns=@JoinColumn(name="file_name", referencedColumnName="file_name"))
    private List<Clob> xmlContents;

    @Transient
    public List<ReportingFile> getReports() {
        List<ReportingFile> reports = new ArrayList<ReportingFile>();

        for(Clob xmlContent: getXmlContents())
            reports.add(new ReportingFile(getFileName(), xmlContent));

        return reports;
    }

    @Embeddable
    public static class ReportingFile implements Serializable {

        // required no-arg  constructor
        public ReportingFile() {}

        public ReportingFile(String fileName, Clob xmlContent) {
            this.fileName = fileName;
            this.xmlContent = xmlContent;
        }

        // You must set up insertable=false, updatable=false
        @Column(name="file_name", insertable=false, updatable=false)
        private String fileName;

        @Column(name="xml_content")
        private Clob xmlContent;

   }

}