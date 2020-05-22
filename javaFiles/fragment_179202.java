while(rec.next()){
    blob = rec.getBlob("template");
    int blobLength = (int)blob.length();  
    blobAsBytes = blob.getBytes(1, blobLength);
}
templater.deserialize(blobAsBytes);         
verificator.setFARRequested(DPFPVerification.MEDIUM_SECURITY_FAR);
DPFPVerificationResult result = verificator.verify(fs, templater);
if (result.isVerified())
    System.out.print("The fingerprint was VERIFIED.");