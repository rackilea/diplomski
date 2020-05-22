// "xyz" is interned , JVM will create this object and keep it in String pool
String x = "xyz";
// a new String object is created here , x still refers to "xyz" 
x.toUpperCase(); 
// since char literal `Y` is not present in String referenced by x ,
// it returns the same instance referenced by x 
String y = x.replace('Y', 'y'); 
//  "abc" was interned and y+"abc" is a new object
y = y + "abc";  
System.out.println(y);