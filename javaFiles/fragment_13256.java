List<String> selectedFilesAsStrings = list_fileListing.getSelectedValuesAsList();
//selectedFilesAsStrings will never be null, but can be empty
List<File> selectedFiles = new ArrayList<File>( selectedFilesAsStrings.size() );
for( String fileName : selectedFilesAsStrings ){
  selectedFiles.add( new File( fileName ) );
}
File[] bar = selectedFiles.toArray( new File[ selectedFiles.size() ] );