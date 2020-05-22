//js
var mySubmitData ='{"myField":"myFieldValue", "secondField":"secondFieldValue"}';
//dto
public class MyDTO implements Serializable {

  private String myField;

  private String secondField;

  MyDTO() {} //important

  public void setMyField() { ...}

  public void setSecondField() { ... }
}
//web resource
    public @ResponseBody MyDTO saveDTO(@Valid final MyDTO myDTO,BindingResult result, Model model){
     System.out.println(myDTO.getMyField + "  " + myDTO.getSecondField;
      return  myDTO;
      //return new MyDTO(); //it's empy object if you don't have default values
    }