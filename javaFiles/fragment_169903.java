Reader r = new InputStreamReader(stdout, "ASCII");
char buf = new char[4096];
int length;
StringBuilder s = new StringBuilder();
while ((length = r.read(buf)) != -1) {
    s.append(buf, 0, length);
}
String str = s.toString();