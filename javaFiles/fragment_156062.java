Elements links = doc.getElementsByTag("cite");  
                String crawlingNode = links.html();
                    crawlingNode = crawlingNode.replaceAll("(?=<).*?(>=?)", ""); //Remove undesired html tags

                    for (Element link : links) {

                    String linkText = link.text()+System.lineSeparator();
                    System.out.println(linkText);
                    httptest.WriteOnFile(writer, linkText);
}