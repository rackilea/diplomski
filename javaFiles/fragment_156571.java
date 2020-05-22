final File file = new File(sFileName);
final File parent_directory = file.getParentFile();

if (null != parent_directory)
{
    parent_directory.mkdirs();
}

FileWriter writer = new FileWriter(file);