ArrayList<String> imageNames = new ArrayList();
imageNames.add("mazda-2013-tokyo-auto-salon.jpg");
imageNames.add("mazda-2013-Volkswagen-CrossBlue-main.jpg");
for ( String imageName : imageNames) {
    URL url = new URL("http://www.autoguide.com/auto-news/wp-content/uploads/2012/12/"+imageName);
    InputStream in = url.openStream();
    OutputStream out = new FileOutputStream(imageName);
    int r;
    while ((r = in.read()) != -1) {
        out.write(r);
    }
    in.close();
    out.close();
}