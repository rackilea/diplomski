List<String> msgResourcesFiles = getMessageResourcesFileNames();
List<String> codeKeys = getListOfCodeMessageResources();
PropertiesFile file = null;
List<String> propKeys = null;
for(String fileName : msgResourcesFiles)
{
 file = new PropertiesFile(fileName);
 propKeys = file.getPropertiesKeysList();
 for(String key : codeKeys)
 {
    if(!propKeys.contains(key))
    {
       throw new Exception("Missing key " + key);
    }
 }
}