// Bogus code!
private static Image FOLDER = getImage("folder.gif");
private static Image FILE = getImage("file.gif");

private static Image getImage(String name)
{
    return name.equals("FRED") ? FOLDER : FILE;
}