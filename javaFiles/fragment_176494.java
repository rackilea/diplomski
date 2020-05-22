int size = driver.findElements(Loc_AttachmentIcon).size();

for (int i = 0 ; i < size ; i++) {
    List<WebElement> list = driver.findElements(Loc_AttachmentIcon);
    WebElement e = list.get(i);

    if(e.getText().contains(".JPG")) {
        //...
    }
}