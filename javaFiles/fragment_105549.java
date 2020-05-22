StringBuilder sb = new StringBulder();
String numStr = String.valueOf(num);
for (int i = numStr.length(); i < number.length(); i++) {
    sb.append('0');
}
sb.append(numStr);
String result = sb.toString();