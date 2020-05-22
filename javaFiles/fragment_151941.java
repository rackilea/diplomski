// Initialize driver, navigate to the page
WebDriver driver = new FirefoxDriver(); // or other browser

// ... (navigate to the page, etc.)

// Find the link by partial link text
WebElement link = driver.findElement(By.partialLinkText("Planning"));

// Get the attribute (entire value)
String onclick = link.getAttribute("onclick");

// From here you can use any of the string parsing to get what you want.
// Here's the simple regex way:
String pid = "";
Pattern pattern = Pattern.compile("pid=([^\\&]*)&"); //search for anything between 'pid=' and '&'
Matcher matcher = pattern.matcher(mydata);
if (matcher.find())
{
    pid = matcher.group(1); // should be only one
}

System.out.println(pid);