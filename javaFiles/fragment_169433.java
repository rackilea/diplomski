StringBuilder sb = new StringBuilder();

for (Element link : links) {

  // Get the value from href attribute
  System.out.println("\nlink : " + link.attr("href"));
  System.out.println("text : " + link.text());
  sb.append("\nlink : " + link.attr("href"));
  sb.append("text : " + link.text());
  sb.append("\n");

}

String finishedParse = sb.toString();