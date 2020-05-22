String imageString = "";
try {
  FileInputStream fin = openFileInput("camera.jpg");
  int jpeg_size = fin.available();
  byte[] imagedata = new byte[jpeg_size];
  fin.read(imagedata);
  byte[] encodedData = Base64.encodeBase64(imagedata);
  imageString = new String(encodedData);
  final String mimetype = "text/html";
  final String encoding = "UTF-8";
  // replace below [ with html "<" and ] similarly ] with ">"
  String html = "[html][body][center][img height=\"200\" width=\"200\"
         src=\"data:image/jpeg;base64,"+imageString+"\"/][/center][/body][/html]";
  mWebView.loadData(html, mimetype, encoding);
} catch (Exception e) {
  e.printStackTrace();
}