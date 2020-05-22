StringBuilder sb = new StringBuilder("http://myweb.com?");
for (int i = 0; i < params.length; ++i) {
  if (i != 0) sb.append("&");
  sb.append("param");
  sb.append(i + 1);
  sb.append("=");
  sb.append(escape(params[i]));
}
String url = sb.toString();