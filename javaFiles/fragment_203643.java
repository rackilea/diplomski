URL website = null;
try {
    website = new URL(ws);
}
catch (MalformedURLException e) {
    e.printStackTrace();
}
ReadableByteChannel rbc = Channels.newChannel(website.openStream());
FileOutputStream fos = new FileOutputStream("weed.jpg");
fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);