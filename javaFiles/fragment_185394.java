class managedBean {

private String stringField ;  // getter and setter

private String stringFieldSetByMethod ;  // getter and setter

 public void setStringField(String sf){
         this.stringField = sf;

         method();
      }

public void method(){

// uses the stringField in some way to set 'stringFieldSetByMethod' ...

                   }

}