@RequestMapping(value = "/addCheck", method = RequestMethod.POST)
@ResponseBody
public SsiCheque addChecks(@Valid @RequestBody SsiCheque ssiCheque, BindingResult result) {

    //ssiCheque.persist();
    System.out.println("agregar " + result.getErrorCount());
    return ssiCheque;
}