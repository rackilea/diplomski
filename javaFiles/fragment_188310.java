...
response.setContentType(myContentType);
BufferedImage im = ImageIO.read(new ByteArrayInputStream(contenido));                           
output.write(contenido);
output.flush();
output.close();
...