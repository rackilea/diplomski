URLConnection conn = url.openConnection();
conn.connect();

inputStream = conn.getInputStream();

bufferedInputStream = new BufferedInputStream(inputStream);

bmp = BitmapFactory.decodeStream(bufferedInputStream);