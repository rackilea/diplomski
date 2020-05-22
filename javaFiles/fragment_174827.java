public void getStoreInfoFromProvider (BlobStore blobStore)
{
    ListContainerOptions listOptions = new ListContainerOptions ();
    // returns a string containing all info of the filesystem on the cloud
    String temp = blobStore.list ("", listOptions.recursive ()).toString (); 

    temp = temp.replaceFirst("\\[\\[", "");
    temp = temp.replaceFirst("\\]\\]", "");
    String[] parts = temp.split("\\[t"); 

    for (String part: parts) 
    {
        String[] elements = part.split(", ");
        System.out.println(elements.length);
        // ...