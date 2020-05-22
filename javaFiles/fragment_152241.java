public boolean matchAlertTextAndClose(String textToMatch){
    Alert javascriptAlert= driver.switchTo().alert();
    String text= javascriptAlert.getText();
    boolean doesTextMatch = false;
    if(text.matches(textToMatch)){
        doesTextMatch = true;
    }
    else{
        doesTextMatch = false;
    }
    javascriptAlert.accept();
    return doesTextMatch;
}