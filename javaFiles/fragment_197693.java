public class Main implements EntryPoint {

       ....
       Registration registration =new Registration();
       registration.addSaveHandler(new SuperPuperHandler<MySavedObject>(){
          public void onFire(MySavedObject t){
              // here is saved objects in registration form
          }
        });

}