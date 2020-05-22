else if(e.getSource() == buttonConfirm){
  System.out.println("confirmed");
  //not needed anymore
  confirm++;

  //invokes the next stage test method 
  ArrayClass.invokeNextStage();     
  System.exit(0);    
}