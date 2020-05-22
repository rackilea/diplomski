URL url = new URL("JSPURL");
URLConnection conn = url.openConnection();
for (int i = 0;; i++) {
  String headerName = conn.getHeaderFieldKey(i);
  String headerValue = conn.getHeaderField(i);
  System.out.println(headerName + "===");
  System.out.println(headerValue);
  if (headerName == null && headerValue == null) {
    break;
  }
}