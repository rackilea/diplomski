-optimizationpasses 5
-dump class_files.txt
-printseeds seeds.txt
-printusage unused.txt
-printmapping mapping.txt
-optimizations !code/simplification/arithmetic,!field/*,!class/merging*/
-allowaccessmodification
-repackageclasses ''

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.MapActivity
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider

-libraryjars  libs/commons-io-2.2.jar
-libraryjars  libs/gson-2.2.2.jar
-keep public class org.apache.commons.io.**
-keep public class com.google.gson.**
-keep public class com.google.gson.** {public private protected *;}

##---------------Begin: proguard configuration for Gson ----------
-keepattributes *Annotation*,Signature
-keep class com.mypackage.ActivityMonitor.ClassMultiPoints.** { *; }
-keep public class com.mypackage.ActivityMonitor$ClassMultiPoints     { public protected *; }
-keep public class com.mypackage.ActivityMonitor$ClassMultiPoints$ClassPoints { public protected *; }
-keep public class com.mypackage.ActivityMonitor$ClassMultiPoints$ClassPoints$ClassPoint { public protected *; }
# To support Enum type of class members
-keepclassmembers enum * { *; } 
##---------------End: proguard configuration for Gson ----------