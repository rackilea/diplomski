class SeqData extends Asn1Seq {

private static final long serialVersionUID = 55L;

  Type1 attribute1;
  Type2 attribute2;

@Override
public int getElementCount() {
    return 2;
}

@Override
public String getElementName(int arg0) {
    switch (arg0) {
    case 0:
        return "attribute1";
    case 1:
        return "attribute2";
    }
    return "";
}

@Override
public Object getElementValue(int arg0) {
    switch (arg0) {
    case 0:
        return attribute1;
    case 1:
        return attribute2;
    }
    return null;
}

@Override
public void decode(Asn1PerDecodeBuffer arg0) throws Asn1Exception, IOException {

    attribute1 = new Type1();
    attribute1.decode(arg0, 1L, 62L);

    attribute2 = new Type2();
    attribute2.decode(arg0, 1L, 62L);
}