if (toggleButton.isChecked()){

// Change the background of the activity to image 2 (for example) 
View myView =  this.findViewById(yourViewId); 
myView.setBackgroundResource(yourImage);         
 }

else{ // when toggle button is off

// Change it back to image 1
// Change the background of the activity to image 2 (for example) 
 View myView =  this.findViewById(yourViewId); 
myView.setBackgroundResource(yourOtherImage);
}