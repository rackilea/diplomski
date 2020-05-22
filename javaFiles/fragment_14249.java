import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;

public class WebInfAccessTest
{
    @Test
    public void shouldListJsps()
    {
        File jspFolder = Paths.get("src/main/webapp/WEB-INF/pages").toFile();
        for (File jsp : jspFolder.listFiles())
            System.out.println(jsp.getName());
    }

}

======================================================================
Here is result for my test Maven project
======================================================================
$ mvn test
...
 T E S T S
-------------------------------------------------------
Running WebInfAccessTest
add.jsp
get.jsp
list.jsp
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.073 sec