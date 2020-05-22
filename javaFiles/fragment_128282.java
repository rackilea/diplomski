package com.sdl.ws.integration.profserv.shared.onejar;


import com.simontuffs.onejar.OneJarURLConnection;
import org.reflections.vfs.Vfs;
import org.reflections.vfs.ZipDir;
import org.reflections.vfs.ZipFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class OneJarDir implements Vfs.Dir {

    private JarFile oneJarFile = null;
    private List<Vfs.File> oneJarClassFiles = new ArrayList<Vfs.File>();

    private OneJarURLConnection oneJarConnection;

    public OneJarDir(OneJarURLConnection oneJarConnection) {

        this.oneJarConnection = oneJarConnection;

        try {
            this.oneJarConnection.connect();
            this.oneJarFile = this.oneJarConnection.getJarFile();
            Enumeration<JarEntry> entries = oneJarFile.entries();

            while (entries.hasMoreElements()) {
                oneJarClassFiles.add(new ZipFile(new ZipDir(oneJarFile), entries.nextElement()));
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't create One-Jar VFS directory", e);
        }
    }

    public String getPath() {
        return oneJarConnection.getURL().getPath();
    }

    public Iterable<Vfs.File> getFiles() {
        return oneJarClassFiles;
    }

    public void close() {
        try {
            if (oneJarConnection != null)
                oneJarConnection.getInputStream().close();
        } catch (IOException e) {
            throw new RuntimeException("Can't close VFS JAR stream", e);
        }
    }
}