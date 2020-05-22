Signature sig = Signature.getInstance("SHA256withRSA"); // Adjust as necessary
sig.initVerify(publicKey);
sig.update(dataThatWasSigned);

try {
  boolean validSignature = sig.verify(signatureYouReceived);
} catch (SignatureException e) {
  // Graceful handling belongs here...
}