-keepattributes 

    Signature,LineNumberTable,*Annotation*,LocalVariableTable,SourceFile
    -keep public class * { public protected *;}

    -keepclassmembers class **.R$* {
    public static <fields>;
    }

    -keepclassmembers class com/compny/blha/proj/Class/Container
    {

    }
    -keep fields com/compny/blha/proj/Class/VersionUID long;