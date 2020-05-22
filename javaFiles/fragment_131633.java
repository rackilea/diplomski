private void selectImage(String image)
{
    String location= System.getProperty("user.dir");
    imageSelect.clear();
    imageSelect.sendKeys(location+image); 
}