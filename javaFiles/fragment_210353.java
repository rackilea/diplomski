String pat = "(?!^)\\.(?=[^.]*$)|(?<=^\\.[^.]{0,1000})$";
String s = ".MyFile";
System.out.println(Arrays.toString(s.split(pat,-1)));
s = "MyFile.ext";
System.out.println(Arrays.toString(s.split(pat,-1)));
s = "Another.MyFile.ext";
System.out.println(Arrays.toString(s.split(pat,-1)));
s = "MyFile.";
System.out.println(Arrays.toString(s.split(pat,-1)));