StringBuilder b = new StringBuilder();
char c = "e".charAt(0);
System.out.println(c);   //'e'
System.out.println(c+0); //101 -ascii
b.append(c+=c+0); // result of c+c+0 is int 202, it is converted to char Ê
char d = b.charAt(0); // char d = Ê
System.out.println(d-=d+0); // result of d-(d+0) is int 0, it will be converted to null