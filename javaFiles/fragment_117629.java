String encoding = "UTF-8"; /* You need to know the right character encoding. */
InputStream s1 = ..., s2 = ..., s3 = ...;
Enumeration<InputStream> streams = 
  Collections.enumeration(Arrays.asList(s1, s2, s3));
Reader r = new InputStreamReader(new SequenceInputStream(streams), encoding);
char[] buf = new char[2048];
StringBuilder str = new StringBuilder();
while (true) {
  int n = r.read(buf);
  if (n < 0)
    break;
  str.append(buf, 0, n);
}
r.close();
String contents = str.toString();