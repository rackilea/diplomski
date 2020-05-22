@PostContextCreate
public void postContextCreate()
{   
  Location instanceLoc = Platform.getInstanceLocation();

  // Stop if location is set
  if (instanceLoc.isSet())
    return;

  File file = new File("C:\\TEST");

  instanceLocation.set(file.toURL(), false);
}