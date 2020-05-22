public class MyTapestryComponentsModule {

   public static void contributeComponentClassResolver(
            Configuration<LibraryMapping> configuration) {
        configuration.add(
            new LibraryMapping("myprefix", "my.tapestry.basepackage"));
   }

}