for (Annotation a : AnnotationTest.class.getDeclaredAnnotations()) {
   if (a instanceof Author) {
      Author author = (Author) a;
      System.out.println("Author Name: " + author.name());
      System.out.println("Date: " + author.date());

   } else if (a instanceof Revision) {
      Revision revision = (Revision) a;
      System.out.println("Version: " + revision.version());
      System.out.println("Modified By: " + revision.modifiedBy());
   } 
}