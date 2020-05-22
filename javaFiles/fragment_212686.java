String jsScript = "return $('a.someclassname:visible').filter(function () { return $(this).text() == 'Move to next page'; });";
Object object = ((JavascriptExecutor)this.driver).executeScript(jsScript, new Object[0]);
if (WebElement.class.isInstance(object))
{
    return (WebElement) object;
}
if (List.class.isInstance(object))
{
    return (WebElement) ((List)object).stream().filter(WebElement.class::isInstance).findFirst().orElse(null);
}
return null;