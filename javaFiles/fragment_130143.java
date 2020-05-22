@And("^the following options are displayed$")
public void the_following_options_are_displayed(DataTable options) {
List<List<String>> data = options.raw();
List<WebElement> optionsIcons = driver.findElements(By.className("options-icons"));
int count = 0;
for (WebElement optionsIcon : optionsIcons) {
    count = 0;
    for (int i = 0; i < data.size(); i++) {

        if(optionsIcon.getText().contains(data.get(i).get(1))==true){
            count ++;

        }
    }
    Assert.assertTrue("There is no match found with these options", count!=0);

    }
}