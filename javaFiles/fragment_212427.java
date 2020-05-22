WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_9);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setCssEnabled(true);     
        HtmlPage page = (HtmlPage) webClient.getPage("http://www.sears.com/search=little tikes&Little Tikes?filter=Brand&keywordSearch=false&vName=Toys+%26+Games&catalogId=12605&catPrediction=false&previousSort=ORIGINAL_SORT_ORDER&viewItems=50&storeId=10153&adCell=W3");
        WebResponse response = page.getWebResponse();
        String content = response.getContentAsString();
        System.out.println(page.getUrl());