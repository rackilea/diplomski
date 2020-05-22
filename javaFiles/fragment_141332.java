-injars 'B:\Java\ProGuardTestApp\test.jar'
-outjars 'B:\Java\ProGuardTestApp\testObf.jar'
-dontshrink
-dontoptimize
-classobfuscationdictionary 'B:\Java\ProGuardTestApp\obfs.txt' # contains just one line "final"
-repackageclasses 'nul.goto. ...\\.. .final.'
-ignorewarnings
-keepclasseswithmembers public class * {
    public static void main(java.lang.String[]);
}