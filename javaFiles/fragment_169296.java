>javap -c -classpath . Quark 
Compiled from Quark.java 
public final class Quark extends java.lang.Object { 
    public Quark(java.lang.String,double); 
}
Method Quark(java.lang.String,double) 
   0 aload_0 
   1 invokespecial #1 <Method java.lang.Object()> 
   4 aload_0 
   5 aconst_null 
   6 putfield #2 <Field java.lang.String fName> 
   9 aload_0 
  10 dconst_0 
  11 putfield #3 <Field double fMass> 
  14 aload_0 
  15 aload_1 
  16 putfield #2 <Field java.lang.String fName> 
  19 aload_0 
  20 dload_2 
  21 putfield #3 <Field double fMass> 
  24 return