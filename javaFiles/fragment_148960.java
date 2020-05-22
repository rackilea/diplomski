URL url = new URL("http://open.live.bbc.co.uk/weather/feeds/en/2656397/observations.rss");
URLConnection con = url.openConnection();
InputStream in = conn.getInputStream();
FileOutputStream out = new FileOutputStream("output.xml");

byte[] b = new byte[1024];
int count;
while ((count = in.read(b)) >= 0) {
    out.write(b, 0, count);
}
out.flush(); out.close(); in.close();