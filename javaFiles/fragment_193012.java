import javax.sql.DataSource;
import org.apache.ddlutils.Platform;
import org.apache.ddlutils.PlatformFactory;
import org.apache.ddlutils.model.Database;
import org.apache.ddlutils.platform.hsqldb.HsqlDbPlatform;

public void readMetaData(final DataSource dataSource) {
  final Platform platform = PlatformFactory.createNewPlatformInstance(dataSource);
  final Database database = platform.readModelFromDatabase("someName");
  // Inspect the database as required; has objects like Table/Column/etc.
}