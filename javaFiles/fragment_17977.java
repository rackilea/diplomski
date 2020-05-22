public class EmployeeBuilder {

      public EmployeeBuilder(String firstName, String lastName){

      }

      public void setSex(Sex sex){ ... }

      public void setSalutation(Salutation salutation){ ... }

      public Employee build(){
          if(salutation != null){
             return new Emplyoee(firstName, lastName, salutation);
          } else if(sex != null){
             return new Emplyoee(firstName, lastName, sex); 
          } else {
             return new Emplyoee(firstName, lastName);
          }
      }
}