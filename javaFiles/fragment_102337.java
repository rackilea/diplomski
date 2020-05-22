private static void filemove() throws IOException, NoSuchFileException{
     try{
        Files.move( Paths.get("H:/db_sort/pdfs/test_5_database"),Paths.get("H:/db_sort/pdf s/2019-08/test_5_database"));
     }catch(java.nio.file.NoSuchFileException e){
         throw new my.package.NoSuchFileException();
     }
}