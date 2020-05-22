try {
            if (webElements.newCohortElm.isDisplayed()) {
                doApply();
            }
        }
        catch (Exception e){
            SeleniumUtils.click(getDriver(), webElements.createCohortSelectionFromMenu);
            webElements.cohortname.sendKeys("private_cohort_test");
            SeleniumUtils.click(getDriver(), webElements.createCohortButton);
        }