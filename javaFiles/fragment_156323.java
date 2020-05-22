final List<String> options = Arrays.asList("recursive","allFiles","includeDir");

public DirScan createDirScan(String source) {

   // This class comes from a package
   final DirScan dirscan = new DirScan(source, options) {
       @Override
       protected Action getResult(final String result) {
           destination.onNext(result);
           return Action.Continue;
       }
   };

   return dirscan;
}