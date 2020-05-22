String winHandleBefore = driver.getWindowHandle();

    //All tab's id (security + toolsQA) and storing it.
    Set<String> all = driver.getWindowHandles();

    //Get all the tab id's including security and iterate
    for(String winHandle : driver.getWindowHandles())
    {
       if(winHandle.equals(winHandleBefore))
       {
         //Condition satisfied. Switching to the security tab and closing it
         driver.switchTo().window(winHandle);
         driver.close();

       }
    }
    //Now the security tab will be closed we need to switch to the toolsQA whose id is in "all"
    //Removing the security tab id from all.
    all.remove(winHandleBefore);
    //Now we have only one toolsqa id in "all"
    for(String winHandle : all)
    {

         driver.switchTo().window(winHandle);
         //Now in toolsQA