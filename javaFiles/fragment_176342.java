selenium.click("xpath=//span[contains(text(),'Tanzanite Pendant')]");
 selenium.waitForPageToLoad("30000");
 assertTrue(selenium.isTextPresent("Pear Tanzanite and Diamond V-Bale Pendant"));
 selenium.click("xpath=//img[@class='imgsize']/@src[1]");
 selenium.click("css=#option-list-tab272 > span");
 selenium.click("xpath=//div[@id='option-container3341']/div/div/span");
 selenium.click("css=#option-list-tab332 > span");
 selenium.click("xpath=//span[contains(text(),'14K Yellow Gold')]");
 selenium.click("//input[@name='addToCartSubmit' and @value='ADD TO CART']");
selenium.waitForPageToLoad("10000");

      //Some code should be there which might handle the pop-up window.

 selenium.click("xpath=//form[@id='updatepost_form']//*[@id='cart-top-checkout-button']");
 selenium.waitForPageToLoad("30000");
 assertTrue(selenium.isTextPresent("Express Checkout"));