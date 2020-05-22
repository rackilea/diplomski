private DomainJDBCTemplate  domainJDBCTemplate;

    @Autowired
    @Qualifier("studentJDBCTempate")
    public void setDomainJDBCTemplate(DomainJDBCTemplate domainJDBCTemplate) {
        this.domainJDBCTemplate = domainJDBCTemplate;
    }