package com.stackoverflow;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * @author maba, 2012-11-08
 */
public class FileTest {
    @Test
    public void testIfStartScriptIsFile() {
        File file = new File("src/main/scripts/start.bat");
        assertTrue("The tested file is not a real file!!!", file.isFile());
    }
}