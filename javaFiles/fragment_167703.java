if (clickHere.size()>0){   
      clickHere.get(0).click();
      username.sendKeys(strUsername);
      nextBtn.click();
      password.sendKeys(strPassword);
      loginButton.click();
      System.out.println("Successfully Logged");
 }
 else{
      username.sendKeys(strUsername);
      nextBtn.click();
      password.sendKeys(strPassword);
      loginButton.click();
      System.out.println("Successfully Logged");
 }