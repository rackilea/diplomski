List<WebElement> allInputFields = driver.findElements(By.cssSelector("cm-edit-request-form dx-text-area textarea"));
        if(allInputFields.size()!=0){
            for(WebElement allInputFieldsElement:allInputFields){
                if(allInputFieldsElement.isEnabled()) {
                    wait.until(ExpectedConditions.elementToBeClickable((allInputFieldsElement)));
                    allInputFieldsElement.sendKeys("Automation text" + uuid);
                }
            }