public class CanFindElemsTest {

  // Change the class
  ClassYouAreTesting page;

  @Given("^navigate to webpage$")
  public void navigate_to_webpage() throws Exception {

    page.open();
  }


  @Then("^check page elements$")
  public void check_page_elements() throws Exception {

    page.checkPageElementsExist();
  }
}