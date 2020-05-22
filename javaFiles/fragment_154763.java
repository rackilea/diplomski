public void update()
   {
      counter = Integer.parseInt(label3.getText());
      if(counter < 9){
         counter++;
         label3.setText(" " + counter);

      }

      else{ //Correctly checks for larger than 9 in 1's place 
         counter = 0;
         label3.setText(" " + counter);
         counter = Integer.parseInt(label2.getText());
         if(counter < 9){
            counter++;
            label2.setText(" " + counter);

         }
         else{ //This is where code goes wrong
            counter = 0;
            label2.setText(" " + counter);
            counter = Integer.parseInt(label.getText());
         } < ---- This brace should be ...
         if(counter<9){
            counter++;
            label.setText(" " + counter);
         }
         else{
            counter = 0;
            label.setText("0");
         }
       <---- Right over here
      }
   }
}