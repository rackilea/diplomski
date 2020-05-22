String url1 = "http://foo.com/bar/baz";
String url2 = "http://foo.com/bar/qux/quux/corge";

Path p1 = Paths.get(url1);
Path p2 = Paths.get(url2);
Path p  = p1.relativize(p2);

System.out.println("Relative path: " + p);