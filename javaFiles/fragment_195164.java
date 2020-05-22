By mySelector = By.xpath("//android.widget.TextView");
List<WebElement> myElements = driver.findElements(mySelector);
int count = 0;
for(WebElement e : myElements) {

    count++;
    if(e.getText().equals(str1)) {
        System.out.println(count); //This will give the index value
    }
    else{
        //do something else
    }
}