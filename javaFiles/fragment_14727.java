public class SomeWebPage extends PageObject {

  @FindBy(id = "someID")
  private WebElementFacade someElement;

  @FindBy(linkText = "some text")
  private WebElementFacade someLink;

  @FindBy(className = "some-class")
  private WebElementFacade anotherElement;


  public void checkPageElementsExist() throws Exception {

    Field[] allFields = getClass().getDeclaredFields();
    for (Field field : allFields) {

      if (field.get(this) instanceof WebElementFacade) {

        WebElementFacade f = (WebElementFacade) field.get(this);

        if (!f.isPresent()) {

          System.out.println("ElementNotFound: " + field.getName());
        } else {

          System.out.println("Found: " + field.getName());
        }
      }
    }
  }

}