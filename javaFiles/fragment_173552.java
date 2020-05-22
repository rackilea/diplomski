String requestStr = request.getParameter("inputstream");
requestStr = requestStr.substring(1, requestStr.length() - 1);
String dataArray[] = requestStr.split(",");
byte[] rawRequestMsg = new byte[dataArray.length];
int count = 0;
for (String str: dataArray) {
  str = str.trim();
  rawRequestMsg[count++] = Byte.parseByte(str);
}