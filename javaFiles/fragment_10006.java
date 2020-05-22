String imageStr = request.getParameter("image");
byte[] decoded = Base64.decodeBase64(imageStr);

String path = "D:\\myImage.png";
OutputStream out1 = null;

try {
    out1 = new BufferedOutputStream(new FileOutputStream(path));
    out1.write(decoded);            
} finally {
    if (out1 != null) {
        *out1.close();*
    }
}