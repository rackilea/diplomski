StringBuilder finalStringb =new StringBuilder();
String id ="";
        for(int i=0;i<=5;i++){
            id = driver.findElement(By.xpath("//[@id='selectpatientid_"+i+"']")).getText();
        finalStringb.append(id);
           }
        System.out.println(finalStringb);