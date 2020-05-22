//for(int i = 1 ; i<gElements.size();i++){
WebElement button1 =  gElements.get(1 //here was i);

 Actions actionBuilder = new Actions(OpenBrowser.driver);
    actionBuilder.click(button1).build().perform();  
    System.out.println(button1);
    Thread.sleep(1000);//}