String valueBeingChecked="xxxx";
int flag=0;
WebElement drpdwn=driver.findElement(by.id("DROPDOWN_ID");
Select DrpDwnSel=new Select(drpdwn);
List<WebElement> DrpDwnList=DrpDwnSel.getOptions();
  For(WebElement indElem:DrpDwnList){
      if (indElem.getText().contains(valueBeingChecked)){
         Flag=1;
         break;
         }
  }