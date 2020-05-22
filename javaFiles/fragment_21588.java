for (int i = 0; i < alertsTableRowsList.size(); i++){     
    String reference = driver.findElement(By.xpath("//tbody/tr[" + (i + 1) + "]/td[@data-title-text = 'Reference']")).getText();
    String classification = driver.findElement(By.xpath("//tbody/tr[" + (i + 1) + "]/td[@data-title-text = 'Classification']")).getText(); //td number 4
    String description = driver.findElement(By.xpath("//tbody/tr[" + (i + 1) + "]/td[@data-title-text = 'Description']")).getText(); //td number 7
    String status = driver.findElement(By.xpath("//tbody/tr[" + (i + 1) + "]/td[@data-title-text = 'Status']")).getText(); //td number 8
    String date = driver.findElement(By.xpath("//tbody/tr[" + (i + 1) + "]/td[@data-title-text = 'Date']")).getText(); //td number 9
    String owner = driver.findElement(By.xpath("//tbody/tr[" + (i + 1) + "]/td[@data-title-text = 'Owner']")).getText(); //td number 10

    System.out.println("reference : " + reference);
    System.out.println("classification : " + classification);
    System.out.println("description : " + description);
    System.out.println("status : " + status);
    System.out.println("date : " + date);
    System.out.println("owner : " + owner); 
}