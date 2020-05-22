String s = getClass().getName();
int i = s.lastIndexOf(".");
if(i > -1) s = s.substring(i + 1);
s = s + ".class";
System.out.println("name " +s);
Object testPath = this.getClass().getResource(s);
System.out.println(testPath);