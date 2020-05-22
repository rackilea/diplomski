public enum FileType 
{
    FILE('-'), DIRECTORY('d'), SYMLINK('l'), DEVICE('b');

    private char name;

    FileType(char name) 
    {
        this.name = name;
    }

    public static FileType getFileTypeForName(final char name)
    {
        for (FileType type : FileType.values())
            if (type.name == name)
                return type;

        return null;
    }
}