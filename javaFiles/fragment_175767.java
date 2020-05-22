Public Class GenricValidationService extends ValidationService{


 public void Validate(){
 // do stuff here
 }
}



Public Class WebChannelService  extends ValidationService{

  public WebChannelService  (ValidationService validationService){
   this.validationService= validationService;
   }

ValidationService validationService;

public void Validate(){
  genericValidationService.validate();
  // extra validation
 }
}