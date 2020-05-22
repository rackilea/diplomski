URL url = new URL(webPage);
HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

File file = new File(dir, fileName);//need to create a file based on your storage paths

FileOutputStream out = new FileOutputStream(file);
InputStream in = urlConnection.getInputStream();

byte[] buffer = new byte[1024];
int i = 0;
while ((i = in.read(buffer)) > 0) {
    out.write(buffer, 0, i);
}

out.flush();
out.close();
in.close();