@Entity
public class Reporting {

    // You said you just want a single fileName as primary key
    @Id
    @Column(name="file_name", nullable=false)
    private String fileName;

    // You said you still want to have the whole ReportingFile object
    @Embedded
    private ReportingFile reportingFile;

    @CollectionOfElements(fetch=FetchType.EAGER)
    @JoinTable(
        name="t_reports",
        joinColumns=@JoinColumn(name="file_name", referencedColumnName="file_name", insertable=false, updatable=false))
    private List<ReportingFile> reports;

    @Embeddable
    public static class ReportingFile implements Serializable {

        // You must set up insertable=false, updatable=false
        @Column(name="file_name", insertable=false, updatable=false)
        private String fileName;

        @Column(name="xml_content")
        private Clob xmlContent;

   }

}