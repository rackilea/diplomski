s String a = driver.findElement(By.cssSelector(".mst_updt")).getAttribute‌​("innerHTML"); 

String b = driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[7‌​]/div/div/section/di‌​v/div[2]")).getAttri‌​bute("innerHTML"); 

System.out.println("Most read 2 : " + a); 
System.out.println("Most read 3 : " + b);