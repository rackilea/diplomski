private static Map<Integer, String> pictureMap = new HashMap<>();
private static PDF pdf;

public ResponseEntity<?> CreateFont(int pictureNumber) {
    if(pictureMap.containsKey(pictureNumber))
        return response(pictureMap.get(pictureNumber));
    if(pdf == null)
        pdf = new PDF();
    PdfToImg pdfToImg = new PdfToImg();
    List<byte[]> fileBytes = pdfToImg.getImage(pdf.PDFCREATE());
    byte[] encoded = Base64.encodeBase64(fileBytes.get(pictureNumber));
    String encodedString = new String(encoded);
    pictureMap.put(pictureNumber, encodedString);

    return response(encodedString);
}


private ResponseEntity response(String encodedString){
    return new ResponseEntity<String>(
        "<img src='data:image/jpeg;base64," + encodedString + "' alt='' width='420' height='580'>",
        HttpStatus.OK);
}