WebDriverWait wait = new WebDriverWait(driver, 5);
        final By lookup = By.id("radio");
        LOG.debug("Wait for radio to be clickable.");
        wait.until(ExpectedConditions.elementToBeClickable(lookup)); //I assume this implies visibility.
        LOG.debug("Element clickable.  Proceeding into click behavior.");
        wait.until(new Predicate<WebDriver>() {
            @Override
            public boolean apply(WebDriver arg0) {
                LOG.debug("Resolving 'myId' Element");
                WebElement radio = arg0.findElement(lookup);                
                boolean rval = radio.isSelected();
                LOG.debug("Element Resolved and has a state of " + (rval ? "selected" : "not selected"));
                if (!rval) {
                    LOG.debug("Clicking on the Element!");
                    radio.click();
                }
                //If we return false we will loop.  So the first time through we let this click the radio for us.
                //Second time through we should find that the element is clicked.  If it's not we click it again until it represents the state we're wanting.
                return rval;;
            }});