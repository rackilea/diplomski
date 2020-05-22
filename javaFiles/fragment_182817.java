@Component
public class ReportResponseAssembler {

    @Autowired
    private ParameterResponseAssembler parameterResponseAssembler;

    @Autowired
    private TimeRangeResponseAssembler timeRangeResponseAssembler;

    public ReportResponseAssembler makeResponse() {
        return new ReportResponseAssembler();
    }
}

@Component
public class ParameterResponseAssembler {
   //whatever
}