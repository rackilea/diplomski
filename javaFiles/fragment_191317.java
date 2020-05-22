Integer parameter = Integer.valueOf(request.getPathInfo().substring(1));
ImageEntity image = loadImage(parameter);
byte[] binaryImageData = image.getImageData();
OutputStream out = new BufferedOutputStream(new FileOutputStream(
                    "C:\\img.jpg"));
out.write(binaryImageData);