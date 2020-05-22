WebElement element = driver.findElement(XYZ);
         boolean clicked = false;
         do{
                try {
                    element.click();
                } catch (WebDriverException e) {
                    continue;
                } finally {
                    clicked = true;
                }
        } while (!clicked);;