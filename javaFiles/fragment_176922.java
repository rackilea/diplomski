public void onClick(View v) {
 //Handle the buttons
 public void onClick(View v) {
 switch(v.getId())
 {
 case R.id.button_a_id:
 // handle button A click;
 break;
 case R.id.button_b_id:
 // handle button B click;
 break;
 default:
 throw new RuntimeException("Unknow button ID");
   }
      }