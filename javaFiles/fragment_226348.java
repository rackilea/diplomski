URL url2 = new URL("http://lostredemption.com/LostRedemption.jar");
HttpURLConnection httpcon = (HttpURLConnection) url2.openConnection();
httpcon.addRequestProperty("User-Agent", "Mozilla/4.0");
ReadableByteChannel rbc = Channels.newChannel(httpcon.getInputStream());
FileOutputStream fos = new FileOutputStream(directory);
fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);