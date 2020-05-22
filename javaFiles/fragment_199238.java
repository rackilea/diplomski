ArrayList<URL> urlList = new ArrayList();
urlList.add(new URL("http://www.autoguide.com/auto-news/wp-content/uploads/2012/12/mazda-2013-tokyo-auto-salon.jpg"));
urlList.add(new URL("http://www.autoguide.com/auto-news/wp-content/uploads/2012/12/mazda-2013-tokyo-auto-salon.jpg"));
urlList.add(new URL("http://www.autoguide.com/auto-news/wp-content/uploads/2012/12/mazda-2013-tokyo-auto-salon.jpg"));
urlList.add(new URL("http://www.autoguide.com/auto-news/wp-content/uploads/2012/12/mazda-2013-tokyo-auto-salon.jpg"));
int i = 1;
for (URL url : urlList) {
  InputStream in = url.openStream();

  OutputStream out = new FileOutputStream("image" + i + ".png");
  i++;
  int r;
  while ((r = in.read()) != -1) {
   out.write(r);
   }
   in.close();
   out.close();
 }