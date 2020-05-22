public @interface Class {
  String author() default "";
  String contact() default "";
  String creationDate() default "";
  String creationTime() default "";

  String lastUpdateDate() default "";
  String lastUpdateTime() default "";

  int version() default 1;
  int majorVersion() default 0;
  int minorVersion() default 0;
  int build() default 1;
}