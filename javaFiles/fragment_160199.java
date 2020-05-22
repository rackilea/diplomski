package com.sandbox;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class SandboxTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    private File level1;
    private File level2a;
    private File level2b;

    @Before
    public void setUp() throws Exception {
        level1 = folder.newFolder("level1");
        level2a = folder.newFolder("level1/level2a");
        level2b = folder.newFolder("level1/level2b");
    }

    @Test
    public void whenCreatingNestedFoldersThenAllGetDeleted() {
        assertTrue(level1.exists());
        assertTrue(level2a.exists());
        assertTrue(level2b.exists());

        System.out.println(level1.getAbsolutePath());
    }

}