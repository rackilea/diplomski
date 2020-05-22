PdfPKCS7 pdfPkcs7 = acroFields.verifySignature(name);
pdfPkcs7.verify();

Field digestField = PdfPKCS7.class.getDeclaredField("digest");
digestField.setAccessible(true);
byte[] digest = (byte[]) digestField.get(pdfPkcs7);