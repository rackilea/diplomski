Object getValueForMyAnnotaion(MyClass obj) {
   Field[] fieldList = obj.getClass().getDeclaredFields();

   for (Field field : fieldList) {
       if (field.isAnnotationPresent(MyAnnotation.class)) {
          return field.get(obj);
       }
   }
}