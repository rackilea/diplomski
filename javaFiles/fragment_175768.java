Public Class ServiceB extends ValidationService{

  public ServiceB (ValidationService validationService){
    this.validationService= validationService;
   }

  ValidationService validationService;

public void Validate(){
  validationService.validate();
  // extra validation
 }
}