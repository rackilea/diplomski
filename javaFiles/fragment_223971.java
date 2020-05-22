@FindBy(id = "...")
private WebElement mainSelect;

public void assertSelectedValue(String value)
    select = getSelect(mainSelect);
    List<WebElement> options = select.getOptions();
    boolean optionExists = false;
    for (WebElement e : options) {
        if (e.getText().equals(value)) {
           optionExists = true;
           break;
        }
    }
    assertTrue("Option x should exist", optionExists);
}