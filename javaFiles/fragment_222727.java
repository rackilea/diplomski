InputStream is = new URL(url).openStream();
int ch;
StringBuilder sb = new StringBuilder();
while((ch = is.read()) != -1)
sb.append((char)ch);            
JSONObject jsonObject = new JSONObject(sb.toString());