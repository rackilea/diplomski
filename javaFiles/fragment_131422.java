-keep public class * extends android.view.View {
   public <init>(android.content.Context);
   public <init>(android.content.Context, android.util.AttributeSet);
   public <init>(android.content.Context, android.util.AttributeSet, int);
   public void set*(...);
}

-keepclasseswithmembers class * {
   public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
   public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * implements android.os.Parcelable {
   static android.os.Parcelable$Creator CREATOR;
}

-keepclassmembers class **.R$* {
   public static <fields>;
}