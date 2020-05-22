public void Filterselection_1() throws Exception{

Properties APPTEXT = new Properties();
FileInputStream fs = new FileInputStream("C:\\FilterSection\\visualization.properties");
APPTEXT.load(fs);
String[] expectedDropDownItemsInArray = APPTEXT.getProperty("visualizationId").trim().split(",");

// Create expected list :: This will contain expected drop-down values
ArrayList<String> expectedDropDownItems = new ArrayList<String>();
for(int i=0; i<expectedDropDownItemsInArray.length; i++)
    expectedDropDownItems.add(expectedDropDownItemsInArray[i]);
JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("document.getElementById('visualizationId').style.display='block';");

// Create a webelement for the drop-down
WebElement visualizationDropDownElement = driver.findElement(By.id("visualizationId"));

// Instantiate Select class with the drop-down webelement
Select visualizationDropDown = new Select(visualizationDropDownElement);

// Retrieve all drop-down values and store in actual list
List<WebElement> valuesUnderVisualizationDropDown  = visualizationDropDown.getOptions();

List<String> actualDropDownItems = new ArrayList<String>();

for(WebElement value : valuesUnderVisualizationDropDown){
    actualDropDownItems.add(value.getText());
}

// Print expected and actual list
System.out.println("expectedDropDownItems : " +expectedDropDownItems);       
System.out.println("actualDropDownItems : " +actualDropDownItems);

// Verify both the lists having same size
if(actualDropDownItems.size() != expectedDropDownItems.size())
  System.out.println("Property file is NOT updated with the drop-down values");

// Compare expected and actual list
for (int i = 0; i < actualDropDownItems.size(); i++) {
    if (!expectedDropDownItems.get(i).equals(actualDropDownItems.get(i)))
    System.out.println("Drop-down values are NOT in correct order");

}