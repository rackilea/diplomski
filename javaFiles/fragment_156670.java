driver.get("http://www.software-testing-tutorials-automation.com");     
    String ExpextedTitle="Software testing tutorials and automatio";
    String ActualTitle=driver.findElement(By.xpath("//h1[@class='title']")).getText();
    Assert.assertEquals(ActualTitle, ExpextedTitle);
    IntegrationWithTestLink.updateResult("GR-1", null, TestLinkAPIResults.TEST_PASSED);
 }catch(AssertionError e){
     System.out.println("Hiiiii");
     IntegrationWithTestLink.updateResult("GR-1", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
 }