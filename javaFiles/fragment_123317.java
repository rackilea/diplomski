@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker
{
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker1
  { 
String author();
  }

@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker2
  {
String author();
String module();
double version(); 
  }