import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTests {

    @Test
    public void directoryTest() {

        // ExplorerView class is tested
        ExplorerView explorer = new ExplorerView();

        explorer.countFilesAndFolders("ExplorerViewTestFolder");

        // assert statements
        assertEquals("filecount must be same ", 12, explorer.getNumberFiles());
        assertEquals("directorycount must be same ", 2, explorer.getNumberDirectories());
    }

}