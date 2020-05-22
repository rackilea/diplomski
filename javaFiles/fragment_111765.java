// read from base64 String
ASN1Sequence seq = (ASN1Sequence) DERSequence.fromByteArray(Base64.decode(base64String.getBytes()));
int n = seq.size();
for (int i = 0; i < n; i++) {
    ASN1Encodable obj = seq.getObjectAt(i);
    if (obj instanceof DEROctetString) {
        System.out.println(new String(((DEROctetString) obj).getOctets()));
    } else {
        System.out.println(obj);
    }
}