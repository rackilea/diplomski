// import FileUtils
import org.apache.commons.io.FileUtils;

// ...

if (oldStartmenu.exists())
{
    FileUtils.deleteDirectory(oldStartmenu);
}