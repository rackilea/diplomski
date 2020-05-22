String str="";
 String id ="";
    for(int i=0;i<=5;i++){
        id = driver.findElement(By.xpath("//[@id='selectpatientid_"+i+"']")).getText();
    str.concat(id);
       }
    System.out.println(str);