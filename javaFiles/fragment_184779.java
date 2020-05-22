@WebServiceClient(name = "CalculatorService",...)
public class CalculatorService
extends Service
{

 ….
 @WebEndpoint(name = "ICalculator")
    public ICalculator getICalculator(WebServiceFeature... features) {
     .....
    }
…
}