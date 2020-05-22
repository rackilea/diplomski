while ((inputStream.read(c1) != -1)) {
    standardOutput.append(c1.toString());
}
System.out.println("Standard Output: " + standardOutput.toString());

int n2;
byte[] c2 = new byte[4096];
StringBuffer standardError = new StringBuffer();
while (errorStream.read(c2) != -1) {
    standardError.append(c2.toString());
}