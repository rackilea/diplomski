u = new URL("http://s.ll/message/" + counter);

 is = u.openStream(); // throws an IOException

 // XXX notice the charset set to utf-8 here.
 BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"));

 while ((s = reader.readLine()) != null) {
   if (s.contains('%')
      ...
 }