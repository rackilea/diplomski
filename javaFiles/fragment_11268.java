public static void switchToTheParentFrame(final WebDriver driver) {
        driver.switchTo().defaultContent();
        iframeList.remove(iframeList.size() - 1);
        final Iterator<By> itr = iframeList.iterator();
        if (!iframeList.isEmpty()) {
            while (itr.hasNext()) {
                final WebElement frame = driver.findElement(itr.next());
                try {
                    driver.switchTo().frame(frame);
                } catch (final WebDriverException wde) {
                    LOG.error("Error while switching to the frame : " + frame.toString(), wde);
                }
            }
        }
    }