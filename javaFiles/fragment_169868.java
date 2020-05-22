# Needed by google-api-client to keep generic types and @Key annotations accessed via reflection
-keep public final class * 
-keep public class *

-keepclassmembers class * {
  public <fields>;
  static <fields>;
  public <methods>;
  protected <methods>;
}

-keepclassmembers class * extends com.google.api.client.json.GenericJson{
  public <fields>;
  static <fields>;
  public <methods>;
}

-keepattributes Signature,RuntimeVisibleAnnotations,AnnotationDefault