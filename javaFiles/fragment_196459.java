try {
    URL url = new URL("http://....");
    Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
} catch(IOException e) {
    System.out.println(e);
}