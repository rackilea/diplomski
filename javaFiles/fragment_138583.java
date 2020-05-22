public void testMain(Object[] args) 
{
    ProcessTestObject pto = startBrowser("http://www.myurl.com");
    System.out.println("PTO "+ pto.getProcessId());
    TestObject[] browsers = find(atChild(".class", "Html.HtmlBrowser" ));
    for(TestObject browser:browsers)
    {
        if(pto.getProcessId() == browser.getProcess().getProcessId())
        {
            //we hv a match, use it 
            ((BrowserTestObject)browser).maximize();
        }

    }
    unregisterAll();    

}