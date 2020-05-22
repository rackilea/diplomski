try{
    String Gender=findElement(By.xpath("yourElementPath")).getText();
    System.out.println("Input field has value = "+Gender);
}
catch(Exception e){
    Log.error("Input field 'Gender' is empty");
}