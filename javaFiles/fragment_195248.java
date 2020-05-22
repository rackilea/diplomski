@Then("^Set  value of  \"Transit\" checkbox to (.*)$")
public void enter_rucNo_check_transit(String check) throws InterruptedException {
    driver_interactions.checkBoxSelect("mrclBulkHeader.transit", string.equalsIgnoreCase("true"));
}
@Then("^Set value of \"Air Transit\" checkbox to (.*)$")
public void enter_rucNo_check_transit(String check) throws InterruptedException {
    driver_interactions.checkBoxSelect("mrclBulkHeader.airTransit", string.equalsIgnoreCase("true"));
}