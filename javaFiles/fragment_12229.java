>javap -classpath . test
public class test extends org.mozilla.javascript.NativeFunction implements org.m
ozilla.javascript.Script{
    public test(org.mozilla.javascript.Scriptable, org.mozilla.javascript.Contex
t, int);
    public test();
    public static void main(java.lang.String[]);
    public final java.lang.Object exec(org.mozilla.javascript.Context, org.mozil
la.javascript.Scriptable);
    public final java.lang.Object call(org.mozilla.javascript.Context, org.mozil
la.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[])
;
    public int getLanguageVersion();
    public java.lang.String getFunctionName();
    public int getParamCount();
    public int getParamAndVarCount();
    public java.lang.String getParamOrVarName(int);
    public java.lang.String getEncodedSource();
    public boolean getParamOrVarConst(int);
}