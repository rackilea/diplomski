@CollectionOfElements(fetch=FetchType.EAGER)
@JoinTable(name="t_reports", 
    joinColumns={
        // The number of columns defined by our Compound primary key (2)
        // must match the number of columns defined by its Foreign key (2)
        @JoinColumn(name="file_name", referencedColumnName="file_name"),
        @JoinColumn(name="xml_content", referencedColumnName="xml_content")})
@Fetch(FetchMode.SELECT)
private List<ReportingFile> reports;