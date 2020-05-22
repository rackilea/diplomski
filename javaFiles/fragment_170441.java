public File getRootPath(Context context, Uri sdcardRootUri)
{
    List<String> pathSegments =  sdcardRootUri.getPathSegments();
    String[] tokens = pathSegments.get(pathSegments.size()-1).split(":");
    for (File f : ContextCompat.getExternalFilesDirs(context, null))
    {
        String path = f.getAbsolutePath().substring(0, f.getAbsolutePath().indexOf("/Android/"));
        if (path.contains(tokens[0]))
        {
            return new File(path);
        }
    }
    return null;
}