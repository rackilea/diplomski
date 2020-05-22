byte[] pdfData = PDF.getPdfOrdini(xxx, tipo);
char[] data = new char[pdfData.length];
for (int i = 0; i < pdfData.length; i++) {
    data[i] = (char) pdfData[i];
    }
response.setContentType( "application/x-download" );
response.setHeader( "Content-Disposition", "attachment; filename=" + downloadFileName );
response.setHeader("Content-length", Integer.toString(data.length));
out.write( data, 0, data.length);
out.flush();