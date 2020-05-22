/**
 * Takes a parent element and strips out the textContent of all child elements and returns textNode content only
 * 
 * @param e
 *            the parent element
 * @return the text from the child textNodes
 */
public static String getTextNode(WebElement e)
{
    String text = e.getText().trim();
    List<WebElement> children = e.findElements(By.xpath("./*"));
    for (WebElement child : children)
    {
        text = text.replaceFirst(child.getText(), "").trim();
    }
    return text;
}