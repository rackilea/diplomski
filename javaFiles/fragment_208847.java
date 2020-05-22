@RequestMapping(value = "submitReportQuery", method = RequestMethod.POST, consumes="application/json" )
public String submitReportQuery(@RequestBody ReportQueryMapBean reportQueryMap)throws Exception{
     //model.addAttribute("successful", true);
     return "queries/SelfServiceQueriesSubmitResults";
}

public class ReportQueryMapBean {
    // to do delcare the bean fields to match the request
    // and corresponding getter and setter function
}