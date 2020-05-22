Elements pages = document.select("div.pagination a");
for(Element page : pages) {
    // Load the next page
    Document nextPage = Jsoup.connect(pages.attr("href"));
    ...
}