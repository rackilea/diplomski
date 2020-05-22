// supported square barcode dimensions
int[] barcodeDimensions = {10, 12, 14, 16, 18, 20, 22, 24, 26, 32, 36, 40, 44, 48, 52, 64, 72, 80, 88, 96, 104, 120, 132, 144};

BarcodeDatamatrix barcode = new BarcodeDatamatrix();
barcode.setOptions(BarcodeDatamatrix.DM_AUTO);

// try to generate the barcode, resizing as needed.
for (int generateCount = 0; generateCount < barcodeDimensions.length; generateCount++) {
    barcode.setWidth(barcodeDimensions[generateCount]);
    barcode.setHeight(barcodeDimensions[generateCount]);
    int returnResult = barcode.generate(text);
    if (returnResult == BarcodeDatamatrix.DM_NO_ERROR) {
        return barcode.createImage();
    }
}

throw new Exception("Error generating barcode.");