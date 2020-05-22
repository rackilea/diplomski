//hack to remove unwanted CR at the end of each line in SignatureValue and X509Certificate
private void removeWhitespaceFromSignature() {
    Element sig = (Element) document.getElementsByTagName("SignatureValue").item(0);
    String sigValue = sig.getTextContent().replaceAll("\r\n", "");
    sig.setTextContent(sigValue);

    Element cert = (Element) document.getElementsByTagName("X509Certificate").item(0);
    String certValue = cert.getTextContent().replaceAll("\r\n", "");
    cert.setTextContent(certValue);
}