public void adjuntoDocumentacionDelProceso(String expectedMessage) throws Throwable {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        rbt = new Robot();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement upLoad = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(adj_Doc)));
        jse.executeScript("arguments[0].scrollIntoView();", upLoad);
        upLoad.click();
        rbt.delay(800);

        driver.switchTo().activeElement().sendKeys("C:\\Users\\QABCN\\Documents\\contractos\\Contrato 1 FCB.pdf");
        //functionsEspai.adjFile1();

        rbt.delay(1000);
        String message = driver.findElement(By.xpath(popUp_Error_Solic)).getText();
        Assert.assertTrue("No se ha adjuntado el archivo!!!", message.contains(expectedMessage));

        System.out.println("Documento adjuntado correctamente: " + message.toString());

    }```