//get all links and recursively call the processPage method
Elements questions = doc.select("a[href]");
for(Element link: questions){
    if(link.attr("href").contains("mit.edu"))
        processPage(link.attr("abs:href"));
}