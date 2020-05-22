byte[] signature = signer.sign();
StringBuilder hexBuilder = new StringBuilder();
for(b: signature){
    hexBuilder.append(String.format("%02x", b));
}
String hexSignature = hexBuilder.toString();