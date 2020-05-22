PDDocument document = new PDDocument();
PDPage page = new PDPage();
document.addPage(page);

// type 2 (exponential) function with attributes
COSDictionary fdict = new COSDictionary();
fdict.setInt(COSName.FUNCTION_TYPE, 2);
COSArray domain = new COSArray();
domain.add(COSInteger.get(0));
domain.add(COSInteger.get(1));
COSArray c0 = new COSArray();
c0.add(COSFloat.get("1"));
c0.add(COSFloat.get("1"));
c0.add(COSFloat.get("1"));
COSArray c1 = new COSArray();
c1.add(COSFloat.get("0"));
c1.add(COSFloat.get("0"));
c1.add(COSFloat.get("0"));
fdict.setItem(COSName.DOMAIN, domain);
fdict.setItem(COSName.C0, c0);
fdict.setItem(COSName.C1, c1);
fdict.setInt(COSName.N, 1);
PDFunctionType2 func = new PDFunctionType2(fdict);

// radial shading with attributes
PDShadingType3 radialShading = new PDShadingType3(new COSDictionary());
radialShading.setColorSpace(PDDeviceRGB.INSTANCE);
radialShading.setShadingType(PDShading.SHADING_TYPE3);
COSArray coords2 = new COSArray();
coords2.add(COSInteger.get(100));
coords2.add(COSInteger.get(400));
coords2.add(COSInteger.get(50)); // radius1
coords2.add(COSInteger.get(100));
coords2.add(COSInteger.get(400));
coords2.add(COSInteger.get(0)); // radius2
radialShading.setCoords(coords2);
radialShading.setFunction(func);

// invoke shading from content stream
// compress parameter is set to false so that you can see the stream in a text editor
try (PDPageContentStream contentStream = new PDPageContentStream(document, page, AppendMode.APPEND, false))
{
    contentStream.shadingFill(radialShading);
}