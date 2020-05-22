-dontwarn scala.**
-dontwarn java.awt.**
-dontnote java.awt.**
-dontwarn com.badlogic.gdx.jnigen.**
-dontwarn com.badlogic.gdx.backends.android.AndroidDaydream
-dontwarn com.badlogic.gdx.backends.android.AndroidInputThreePlus
-dontwarn com.badlogic.gdx.backends.android.AndroidGraphicsDaydream

-keepclasseswithmembers public class * {
    public static void main(java.lang.String[]);
}

-keep class * implements org.xml.sax.EntityResolver

-keepclassmembers class * {
    ** MODULE$;
}

-keepclassmembernames class scala.concurrent.forkjoin.ForkJoinPool {
    long eventCount;
    int  workerCounts;
    int  runControl;
    scala.concurrent.forkjoin.ForkJoinPool$WaitQueueNode syncStack;
    scala.concurrent.forkjoin.ForkJoinPool$WaitQueueNode spareStack;
}

-keepclassmembernames class scala.concurrent.forkjoin.ForkJoinWorkerThread {
    int base;
    int sp;
    int runState;
}

-keepclassmembernames class scala.concurrent.forkjoin.ForkJoinTask {
    int status;
}

-keepclassmembernames class scala.concurrent.forkjoin.LinkedTransferQueue {
    scala.concurrent.forkjoin.LinkedTransferQueue$PaddedAtomicReference head;
    scala.concurrent.forkjoin.LinkedTransferQueue$PaddedAtomicReference tail;
    scala.concurrent.forkjoin.LinkedTransferQueue$PaddedAtomicReference cleanMe;
}

-keep class com.badlogic.gdx.backends.android.AndroidInput {
  public protected private *;
}

-keep class com.badlogic.gdx.backends.android.AndroidInputFactory {
  public protected private *;
}

-keep class com.badlogic.gdx.backends.android.AndroidInputThreePlus {
  public protected private *;
}

-keep class com.badlogic.gdx.backends.android.AndroidApplicationConfiguration {
  public protected private *;
}

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}