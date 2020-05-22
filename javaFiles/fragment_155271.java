import java.lang.reflect.*;

Param1Type param1;
Param2Type param2;
String className = "Class1";
Class cl = Class.forName(className);
Constructor con = cl.getConstructor(Param1Type.class, Param2Type.class);
Object xyz = con.newInstance(param1, param2);