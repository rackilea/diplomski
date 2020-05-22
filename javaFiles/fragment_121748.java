String arrayOfStrings;

@Autowired
public ViewableReportFilter(
        @Value("${TMSViewableReportFilter.allStates.verify}") String[] verifyStringStates) {
        arrayOfStrings = verifyStringStates;


public logViewableReportFilter() {
    log.debug("Read in properties for states: verify:" + arrayOfString);
}