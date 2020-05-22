private boolean isReadOnlyFile(Path file)
    {
        if(Platform.isWindows())
        {
            if (!file.toFile().canWrite())
            {
                DosFileAttributes dosAttr;
                try
                {
                    dosAttr = Files.readAttributes(file, DosFileAttributes.class);
                    if(dosAttr.isReadOnly())
                    {
                        return true;
                    }
                }
                catch (IOException e)
                {

                }
            }
        }
        return false;
    }