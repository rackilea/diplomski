String data = "someBigOrSmallData";

InputStream dataStream = new ByteArrayInputStream(data.getBytes());

response().setHeader("Content-disposition","attachment; filename=anyFileName.txt");

return ok(dataStream);