void test()
{
    String[] pathParts = getStrings();
    FILE_PATH_STRING = pathParts[0] + pathParts[1] + pathParts[2] + pathParts[3];
}

String[] getStrings()
{
    String[] ret = new String[4];
    ret[0] = "The world";
    ret[1] = "South America";
    ret[2] = "Chile";
    ret[3] = ".txt";
    return ret;
}