// inject the service
@Autowired
IncomeBonusService incomeBonusService;

void foo(){       
   // create a domain object that has only data
   List<Income> incomes = ...; 
   // invoke a service method by passing data as parameter
   incomeBonusService.applyChristmasBonus(incomes); 
}