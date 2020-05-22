PageCreator dpc = new DefaultPageCreator();
HtmlPage detailPage = null;
for (int j = 2 ; j<= 11; j++){ // there are 10 pages
detailPage = (HtmlPage)dpc.createPage(htmlPage.getWebResponse(),webClient.openWindow(htmlPage.getUrl(),"ew Window"));
detailPage = ((HtmlElement)detailPage.getFirstByXPath("MYXPATH")).click();
detailPage = ((HtmlElement)((HtmlPage)detailPage ).getFirstByXPath("MYXPATH2")).click(); // download element
webClient.setCurrentWindow(htmlPage.getEnclosingWindow()); //go back to main window
}// end FOR