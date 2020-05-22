PdfNumber pageRotation = pageDict.getAsNumber(PdfName.ROTATE);
if (pageRotation == null) {
    pageDict.put(PdfName.ROTATE, new PdfNumber(90));
}
else {
    pageDict.put(PdfName.ROTATE, new PdfNumber((pageRotation .intValue() + 90) % 360));
}