HttpResponse httpResponse = Unirest.get("https://ronreiter-meme-generator.p.rapidapi.com/meme?font=Impact&font_size=50&meme=Condescending-Wonka&top=Top+text&bottom=Bottom+text")
        .header("X-RapidAPI-Key", "YOUR_SECRET_API_KEY")
        .asBinary();
InputStream inputStream = httpResponse.getRawBody();
BufferedImage imBuff = ImageIO.read(inputStream);
String filePath = "C:/x/x.jpg";
File file = new File(filePath);
ImageIO.write(imBuff, "jpg", file);