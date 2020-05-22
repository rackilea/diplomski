class FolderMaker{
      private String base="/home/user/base/"; // should be configurable, but this is sample

      public boolean mkdir(name){
          return new File(base, name).mkdir();
      }
}