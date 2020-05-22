final URL url = new URL("http://www.rssmix.com/u/8171434/rss.xml");
URLConnection urlConn = url.openConnection();
urlConn.setConnectTimeout(1000);
urlConn.setReadTimeout(1000);

final Document doc = builder.parse(urlConn.getInputStream());