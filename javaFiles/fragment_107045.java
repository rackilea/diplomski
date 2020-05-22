DomElement button = (DomElement) form.getFirstByXPath("//button[@id='logincontrol_submitbutton']");

text.setValueAttribute("Ziplok Java");

HtmlPage resultPage = (HtmlPage) button.click();
System.out.println(resultPage.asText());