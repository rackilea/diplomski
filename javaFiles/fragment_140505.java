public class View{

       private JList cityList;

       private JButton selectCityButton;
       //other stuff

       public String getSelectedCity(){
              cityList.getSelectedItem().toString();
       }

       public void addListenerToOkButton(ActionListener alistener){
               selectCityButton.addActionListener(alistener);
       }

       public void swithClockToCity(Long time){
         //change the clock panel or something...
         //I put here your code:
          myClock.setText(secondsAsTimeText(time));
       }


}