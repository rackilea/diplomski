@GetMapping("/findAccountData/")
public ResponseEntity<List<Tuple>>
populateGridViews(@RequestParam("clientAcctId") String
                          sClientAcctId, @RequestParam("acctDesc") String sAcctDesc, @RequestParam("investigatorName") String sInvestigatorName, @RequestParam("clientDeptId") String
                          sClientDeptId) throws Exception {
}