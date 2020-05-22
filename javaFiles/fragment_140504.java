public class Controller {

       private final View view;

       private final Model model;

       public Controller(View aview, Model aModel){
              this.view=aview;
              this.model=amodel;
              registerListeners();
       }

      public void registerListener(){
             ActionListener actionListener= new ActionListener(){
                       public void actionPerformed(ActionEvent e) {    
                              String city=view.getSelectedCity();
                              view.swithClockToCity(model.getCityTime(city));                                 
                       }

             }; 
         view.addListenerToOkButton(actionListener);
      }


   }