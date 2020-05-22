import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
//...
while (rs.next())
{
    long oid = rs.getLong(1);
    LargeObject obj = lobj.open(oid, LargeObjectManager.READ);
    Path targetPath = FileSystems.getDefault().getPath("License_Agreement.pdf");
    Files.copy(obj.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
    obj.close();
}