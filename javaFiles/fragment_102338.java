private static void filemove() throws IOException, FileNotSynchronizedException{
     try{
        Files.move( Paths.get("H:/db_sort/pdfs/test_5_database"),Paths.get("H:/db_sort/pdf s/2019-08/test_5_database"));
     }catch(NoSuchFileException e){
         throw new my.package.FileNotSynchronizedException();
     }
}