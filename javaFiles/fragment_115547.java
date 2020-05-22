PdfContentByte canvas = writer.getDirectContent();
Barcode128 code128 = new Barcode128();
code128.setCode("12345XX789XXX");
code128.setCodeType(Barcode128.CODE128);
 PdfTemplate template = code128.createTemplateWithBarcode(
        canvas, BaseColor.BLACK, BaseColor.BLACK);