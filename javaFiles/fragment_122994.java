inputStream = new BufferedInputStream(this.url.openStream());
inputStream.mark(2048); // Or some other sensible number

contentTypeParser.parse(inputStream);
contentType = contentTypeParser.getContentType();
contentEncoding = contentTypeParser.getContentEncoding();

inputstream.reset(); // Let the parser have a crack at it now