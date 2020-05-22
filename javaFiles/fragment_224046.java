private final Map<String,String> addressMap = new HashMap<>();

@Given("^a basic street address$")
public void aBasicStreetAddress(Map<String,String> address) {
    addressMap.putAll(address);
}

@When("^I specify Country \"(.+)\"$")
public void iSpecifyCountry(String inputCountry) {
    addressMap.put("country", inputCountry);
}

@Then("^I can print the complete address$")
public void iCanPrintTheCompleteAddress() {
    System.out.println("\n\t" + addressMap.get("streetAddress"));
    System.out.println("\t" + addressMap.get("cityName"));
    System.out.println("\t" + addressMap.get("stateName"));
    System.out.println("\t" + addressMap.get("postalCode"));
    System.out.println("\t" + addressMap.get("country") + "\n");
}