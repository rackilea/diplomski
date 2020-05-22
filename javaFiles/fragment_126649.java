@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public Collection<BudgetDTO> updateConsumerBudget(@RequestBody SomeDto someDto) throws GeneralException, ParseException {

    //whatever

}

class SomeDto {

   private List<WhateverBudgerPerDateDTO> budgetPerDate;


  //getters setters
}