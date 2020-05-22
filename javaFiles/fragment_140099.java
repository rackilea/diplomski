Grok grok = Grok.create("pat.txt");
// compile and add semantic
grok.compile("%{NUMBER:hits} %{USER:word}");

String str = "234 wdfd\n";
Match m = grok.match(str);
m.captures();

// Print
System.out.println(m.toJson());


// Here you dont need to create a new instance of grok [grok = Grok.EMPTY;]
str = "ssdfsdf\n";
// here you can reuse the matcher if you want.
Match m2 = grok.match(str);
m2.captures();

System.out.println(m2.toJson());