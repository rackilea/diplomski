String url = "https://farmaci.agenziafarmaco.gov.it/bancadatifarmaci/cerca-farmaco?search=Tachi";
    try(final WebClient webClient = new WebClient()) {
        final HtmlPage page = webClient.getPage(url);
        final HtmlUnorderedList list = page.getHtmlElementById("ul_farm_results");
        System.out.println(list.asText());
    }