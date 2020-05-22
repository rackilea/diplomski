public static void loadFromFilesNValidateTable(TableDef schema, final File folder) {

    // Process folders recursively        
    for(final File subFolder : folder.listFiles(new DirectoryFilter())){
        loadFromFilesNValidateTable(schema, subFolder);
    }

    // Process data files
    for (final File dataFileEntry : folder.listFiles(new FileNameFilter("test.data"))) {
        BatchUpload.batchUpload(schema,dataFileEntry.getAbsolutePath());
    }

    // Process expected files
    for (final File expectedFileEntry : folder.listFiles(new FileNameFilter("expected-table.data"))) {
        validateData(schema,expectedFileEntry.getAbsolutePath());
    }
} 

public class FileNameFilter implements FileFilter {

        private String name;

        public FileNameFilter(String name){
            this.name = name;
        }

    public boolean accept(File pathname){
        return pathname.getName().equals(name)
    }
}

public class DirectoryFilter implements FileFilter {

    public boolean accept(File pathname){
        return pathname.isDirectory();
    }
}