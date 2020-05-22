try
{
driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
ProjectLibrary.SelectPreviousRecord(xlpath, sheetName, 2, 1);
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
catch (NoSuchElementException ex)
{
ProjectLibrary.SelectPreviousRecord(xlpath, sheetName, 2, 2);
}

try
{
driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
ProjectLibrary.CompareStringTextByID(xlpath, sheetName, 2, 1, "Name","ctl00_ContentPlaceHolder1_txtName");
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
catch (NoSuchElementException ex)
{
ProjectLibrary.CompareStringTextByID(xlpath, sheetName, 2, 2, "Name", "ctl00_ContentPlaceHolder1_txtName");
}