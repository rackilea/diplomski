class OsSpecificPath implements FilePathInterface
{
      String path;

      OsAgnosticPath toAgnosticPath();

      OsSpecificPath concat( OsSpecificPath otherPath );

      // from IFilePath
      getFile();

     ... etc
}