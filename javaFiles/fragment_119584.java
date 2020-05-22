String content = "";
Reader in = new InputStreamReader(this.getClass().getResourceAsStream("asdf.txt"), THE_ENCODING);
StringBuffer temp = new StringBuffer(1024);
char[] buffer = new char[1024];
int read;
while ((read=in.read(buffer, 0, buffer.len)) != -1) {
  temp.append(buffer, 0, read);
}
content = temp.toString().