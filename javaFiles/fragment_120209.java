List<WebElement> myGoal = driver.findElements(By.xpath("//div[starts-with(@id,'goal-GOAL0')]"));// xpath 
    Random rr=new Random();
    System.out.println("Random number is "+rr);
    int randomGoal = rr.nextInt(myGoal.size());
    System.out.println("Goal :"+myGoal.get(randomGoal).getText());
    myGoal.get(randomGoal).click();