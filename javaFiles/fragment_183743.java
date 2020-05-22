for (int j = 0; j < unq_urls.size(); j++) {
  try{
      Response response2 = Jsoup.connect(unq_urls.get(j))
         .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
         .timeout(100*1000)
         .ignoreContentType(true)
         .execute();
  } catch(Exception e) {
      continue; //continue to the next loop if exception occurs
  }
}