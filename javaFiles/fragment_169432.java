for (Element link : links) {

  // Get the value from href attribute
  System.out.println("\nlink : " + link.attr("href"));
  System.out.println("text : " + link.text());
  finishedParse = finishedParse.concat("\nlink : " + link.attr("href"));
  finishedParse = finishedParse.concat("text : " + link.text());
  finishedParse = finishedParse.concat("\n");

}