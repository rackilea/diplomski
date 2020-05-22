class OsAgnosticPath implements FilePathInterface
{
      String path;

      OsSpecificPath toOsSpecificPath();

      OsAgnosticPath concat( OsAgnosticPath otherPath );

      // from IFilePath
      getFile();

     ... etc
}