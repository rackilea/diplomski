List<WebElement> pagerLinkElements = dr.findElements(By.className("UFIPagerLink"));
List<WebElement> socialElements = dr.findElements(By.className("UFIReplySocialSentenceLinkText"));        

List<WebElement> buttonelement = new ArrayList<WebElement>();
buttonelement.addAll(pagerLinkElements);
buttonelement.addAll(socialElements);