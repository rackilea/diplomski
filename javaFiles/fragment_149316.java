@RealmModule(library = true, allClasses = true)
public class MyLibraryModule() {

}

RealmConfiguration config = new RealmConfiguration.Builder()
  .modules(new MyLibraryModule())
  .build();