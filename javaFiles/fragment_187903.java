class StorageFactory
{
  public static Storage getStorage(String type)
  {
    if ( type.equals("list") )
      return new StorageList();
    else if ( type.equals("map") )
      return new StorageMap();
    else if ( type.equals("db") )
      return new StorageDb();

    throw new IllegalArgumentException();
  }
}