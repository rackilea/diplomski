@QAFTestStep(description = "user validate that policy card in desktop {0} contains plan type {1}, policy product {2}, policy value {3}, policy label {4} and status is {5} highlighted in {6}")
    public void userValidateEachPolicyCards(String dataIndex, String planType, String policyProduct, String policyValue, String policyLabel, String policyStatus, String policyStatusColor) {

        String sGetCardBoxStatus;
        String sGetCardBoxColor;
        String sGetCardBoxPlanTypeValue;
        String sGetCardBoxProduct;
        String sGetCardBoxLabel;
        String sGetPolicyNumber;

        sGetCardBoxColor = DriverUtils.getDriver().findElement(By.xpath("*//div[@data-index = '"+ dataIndex +"']/descendant::div[contains(@class, 'card-status')]")).getCssValue("background-color"); //.getAttribute("background-color");
        if((Color.fromString(sGetCardBoxColor).asHex()).equals(policyStatusColor)) {
            Reporter.log("Passed: Policy Status Color: "+ policyStatusColor, MessageTypes.Pass);
        }else {
            Reporter.log("Failed: Policy Status Color is not "+ policyStatusColor, MessageTypes.Fail);
        }

        sGetCardBoxStatus = DriverUtils.getDriver().findElement(By.xpath("*//div[@data-index = '"+ dataIndex +"']/descendant::div[contains(@class, 'card-status')]")).getAttribute("class");
        if(sGetCardBoxStatus.equals(policyStatus)) {
            Reporter.log("Passed: Policy Status: "+ policyStatus, MessageTypes.Pass);
        }else {
            Reporter.log("Failed: Policy Status is not "+ policyStatus, MessageTypes.Fail);
        }

        sGetCardBoxPlanTypeValue = DriverUtils.getDriver().findElement(By.xpath("*//div[@data-index = '"+ dataIndex +"']/descendant::span[contains(@class, 'planType')]")).getText();
        if(sGetCardBoxPlanTypeValue.equals(planType)) {
            Reporter.log("Passed: Plan Type: "+ planType, MessageTypes.Pass);
        }else {
            Reporter.log("Failed: Plan Type is not "+ planType, MessageTypes.Fail);
        }

        sGetCardBoxProduct = DriverUtils.getDriver().findElement(By.xpath("*//div[@data-index = '"+ dataIndex +"']/descendant::span[contains(@class, 'product')]")).getText();
        if(sGetCardBoxProduct.equals(policyProduct)) {
            Reporter.log("Passed: Policy Product: "+ policyProduct, MessageTypes.Pass);
        }else {
            Reporter.log("Failed: Policy Product is not "+ policyProduct, MessageTypes.Fail);
        }

        sGetCardBoxLabel = DriverUtils.getDriver().findElement(By.xpath("*//div[@data-index = '"+ dataIndex +"']/descendant::label[contains(@class, 'policy-label')]")).getText();
        if(sGetCardBoxLabel.equals(policyLabel)) {
            Reporter.log("Passed: Policy Label: "+ policyLabel, MessageTypes.Pass);

            sGetPolicyNumber = DriverUtils.getDriver().findElement(By.xpath("*//div[@data-index = '"+ dataIndex +"']/descendant::span[contains(@class, 'policy-value')]")).getText();
            if(sGetPolicyNumber.equals(policyValue)) {
                Reporter.log("Passed: Policy Number: "+ sGetPolicyNumber, MessageTypes.Pass);
            } 
        else {
                Reporter.log("Failed: Either Policy Label or Policy Number is not found...", MessageTypes.Fail);
            }
        }
    }
}