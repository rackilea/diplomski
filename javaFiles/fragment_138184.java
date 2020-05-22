@Service
@WebService(targetNamespace = "http://example.com/Employee.wsdl")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class EmployeeWebService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeWebService.class);

    @WebMethod(operationName = "getEmployeeDetails")
    @WebResult(partName = "result", targetNamespace = "http://example.com/Employee.wsdl")
    public EmployeeDetailRecUserArray getEmployeeDetails(@WebParam(partName = "employeeIdTab", targetNamespace = "http://example.com/Employee.wsdl") EmployeeIdRecUserArray employeeIdTab) {
        if (employeeIdTab.getEmployeeIdRecUser().isEmpty())
            LOGGER.info("Request is empty.");
        else
            LOGGER.info("Request is not empty");

        return null;
    }