@Autowire
LightService lightService;

@GET
public ResponseEntity<String> toggleLight(){
   try {
       lightService.toggleSwitch();
       //send a 200 OK
   }catch(OptimisticLockingFailureException e) {
      //send a Http status 409 Conflict!
   }
}