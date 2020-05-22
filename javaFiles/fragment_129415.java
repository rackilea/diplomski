try {
  URL url = new URL("http://stackoverflow.com/users/flair/3626698.png?theme=dark");
  HttpURLConnection httpcon = (HttpURLConnection) url.openConnection(); 
  httpcon.addRequestProperty("User-Agent", ""); 
  BufferedImage image = ImageIO.read(httpcon.getInputStream());
  File outputfile = new File("image.jpg");
  ImageIO.write(image, "jpg", outputfile);   
 } 
 catch (Exception e) {
  e.printStackTrace();
 }