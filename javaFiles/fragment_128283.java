package com.sdl.ws.integration.profserv.shared.onejar;

import com.simontuffs.onejar.OneJarURLConnection;
import org.reflections.vfs.Vfs;

import java.io.IOException;
import java.net.URL;

public class OneJarUrlType implements Vfs.UrlType {

    private static final String _JAR_DIR = "jar!";

    public boolean matches(URL url) {

        // check if "double-jarred' by one-jar; this would appear to conflict with the standard JAR loader, so it either needs to be first (which it is)
        // OR the standard needs to be removed. This match assumes a nested JAR, unlike the standard JAR type.
        String externalForm = url.toExternalForm();

        // ugly, but should be much faster than regex.
        int idx1 = externalForm.indexOf(_JAR_DIR);
        return (idx1 > 0 && externalForm.indexOf(_JAR_DIR, idx1 + _JAR_DIR.length()) > 0);
    }

    public Vfs.Dir createDir(URL url) {
        try {
            return new OneJarDir(new OneJarURLConnection(url));
        } catch (IOException e) {
            throw new RuntimeException("Can't open One-Jar embedded JAR", e);
        }
    }

}