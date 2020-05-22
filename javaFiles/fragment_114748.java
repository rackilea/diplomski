@CollectionOfElements(fetch=FetchType.EAGER)
@JoinTable(name="t_reports", 
    // Your mistake goes here
    joinColumns=@JoinColumn(name="log_report"))
@Fetch(FetchMode.SELECT)
private List<ReportingFile> reports;