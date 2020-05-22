public void drawCanvas() {
        Actions builder = new Actions(browser);
        JavascriptExecutor executor = (JavascriptExecutor) browser;
        executor.executeScript("arguments[0].scrollIntoView();", webElement); //Scroll the page and move where the element is located
        Action drawAction = builder.moveToElement(webElement, 135, 15) //start points x axis and y axis.
                .click()
                .moveByOffset(200, 80) // 2nd points (x1,y1)
                .click()
                .moveByOffset(100, 100)// 3rd points (x2,y2)
                .doubleClick()
                .build();
        drawAction.perform();
    }