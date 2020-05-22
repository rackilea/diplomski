@PostMapping(value = "/ProcessRequest",params = "action=Approve")
public String ApproveRequest(@RequestParam Map<String,String> reqPar) {
    String requestId = reqPar.get("requestId");     
    System.out.println(requestId);
    return "home";
}