a.b.C c = new a.b.C();
c.method(new Integer(2)); <--- no Error
c.method(2); <--- no Error
c.method("test"); <--- Error

=============================

ErrorDescription    Resource    Path    Location    Type
"Signature error"   Main.java   /Stackoverflow/src/test line 12 AspectJ Problem