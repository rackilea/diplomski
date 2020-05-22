private List<String> urls = new ArrayList<String>();

//some code

for (Element link : links) {
            if(!urls.contains(link.attr("abs:href"))){
                urls.add(link.attr("abs:href"));
                crawl(link.attr("abs:href"));
            }
}