package drakonli.jcomponents.file.manager;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;

public class NioFileManager implements IFileManager
{
    @Override
    public Path move(Path source, Path target, CopyOption... options) throws IOException
    {
        return Files.move(source, target, options);
    }

    @Override
    public Path copy(Path source, Path target, CopyOption... options) throws IOException
    {
        return Files.copy(source, target, options);
    }

    @Override
    public boolean isSameFile(Path path, Path path2) throws IOException
    {
        return Files.isSameFile(path, path2);
    }

    @Override
    public Path createTempFile(String prefix, String suffix, FileAttribute<?>... attrs) throws IOException
    {
        return Files.createTempFile(prefix, suffix, attrs);
    }
}