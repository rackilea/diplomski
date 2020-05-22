List<String> sentences = new ArrayList<String>();
 Matcher m = Pattern.compile("[^?!.]+(?:[.?!]|$)")
     .matcher("This isn't cool. This doesn't work. This");
 while (m.find()) {
   sentences.add(m.group());
 }