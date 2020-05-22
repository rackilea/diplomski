PdfSigner signer = ...;
PdfSignatureAppearance appearance = signer.getSignatureAppearance();

[... customize the appearance using its usual methods ...]

// call appearance.getAppearance() using reflection
// this initializes the layers in the appearance object
Method getAppearanceMethod = PdfSignatureAppearance.class.getDeclaredMethod("getAppearance");
getAppearanceMethod.setAccessible(true);
getAppearanceMethod.invoke(appearance);

// add a fill color setting instruction
// at the start of layer 2
PdfFormXObject layer2 = appearance.getLayer2();
PdfStream layer2Stream = layer2.getPdfObject();
byte[] layer2Bytes = layer2Stream.getBytes();
layer2Stream.setData("1 0 0 rg\n".getBytes());
layer2Stream.setData(layer2Bytes, true);

signer.signDetached(...);