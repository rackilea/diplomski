public static String getFileExtension(String fileName) 
{
    if (fileName == null || fileName.equals("") || !fileName.contains("."))
        return "";

    return fileName.substring(fileName.lastIndexOf('.'), fileName.length());
}