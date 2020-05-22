public class ToolClassInSeparateJarInSharedDirectory {
    public static void loadNativeLibrary() {
        System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
    }
}

public class WebApplicationClass {
    static {
        ToolClassInSeparateJarInSharedDirectory.loadNativeLibrary();
    }
}