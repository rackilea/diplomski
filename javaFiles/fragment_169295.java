>javap -c -classpath . Quark 
Compiled from Quark.java 
public final class Quark extends java.lang.Object { 
    public Quark(java.lang.String,double); 
}
Method Quark(java.lang.String,double) 
   0 aload_0 
   1 invokespecial #1 <Method java.lang.Object()> 
   4 aload_0 
   5 aload_1 
   6 putfield #2 <Field java.lang.String fName> 
   9 aload_0 
  10 dload_2 
  11 putfield #3 <Field double fMass> 
  14 return