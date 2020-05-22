PdfReader reader = new PdfReader(src);
PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
Map<String, String> info = reader.getInfo();
info.put("Title", null);
stamper.setMoreInfo(info);
stamper.close();
reader.close();