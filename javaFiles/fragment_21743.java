public static File getFileLocation(Class<?> klass)
{
    String classLocation = '/' + klass.getName().replace('.', '/') + ".class";
    URL url = klass.getResource(classLocation);
    String path = url.getPath();
    int index = path.lastIndexOf(classLocation);
    if (index < 0)
    {
        return null;
    }

    String fileCol = "file:";
    //add "file:" for local files
    if (path.indexOf(fileCol) == -1)
    {
        path = fileCol + path;
        index+=fileCol.length();
    }

    // Jar Handling
    if (path.charAt(index - 1) == '!')
    {
        index--;
    }
    else
    {
        index++;
    }

    String newPath = path.substring(0, index);

    System.out.println(url.toExternalForm());
    URI uri = URI.create(newPath).normalize();

    return new File(uri);
}