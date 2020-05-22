WebDriverWait wait = new WebDriverWait(driver, 20);

String errorMessage = "Login attempt exception, error code:";
List<String> expectedMessages = Arrays.asList(
        "Logging in, please wait.",
        "Login successful, please wait.");

wait.pollingEvery(Duration.ofMillis(50))
        .withMessage(String.format("Expecting %s login messages", expectedMessages))
        .until(d -> {
            if (!d.findElement(By.xpath("//p[@class='statusText']")).isDisplayed())
                    return false;

            String actualMessage = d.findElement(By.xpath("//p[@class='statusText']")).getText();
            if (actualMessage.contains(errorMessage))
                Assert.fail(actualMessage);

            String expectedMessage = expectedMessages.get(0);
            if (expectedMessage.contains(actualMessage)) {
                log.info(String.format("Message \"%s\" found", actualMessage));
                expectedMessages.remove(expectedMessage);
            }
            return expectedMessages.size() == 0;
        });