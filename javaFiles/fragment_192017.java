String[] bad = {
     "foo.tar.gz",
     " foo.txt",
     "foo?",
     "foo/",
     "foo\\",
     ".foo",
     "foo."
   };
  String remove_pattern = "^[ .]+|\\.+$|\\.(?=[^.]*\\.[^.]*$)|[?\\\\/:;]"; 
  for (String s: bad) {
       System.out.println(s.replaceAll(remove_pattern, "_"));
  }