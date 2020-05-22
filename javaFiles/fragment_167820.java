WebClient webClient = new WebClient();
    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);

    HtmlPage page = (HtmlPage) webClient.getPage("http://www3.mangafreak.net/Manga/One_Piece");
    System.out.println(page.asXml());

    WebWindow window = page.getEnclosingWindow();
    window.getJobManager().waitForJobsStartingBefore(5000);

    page = (HtmlPage) window.getEnclosedPage();
    System.out.println(page.asXml());