for (Frame frame in Frame.getFrames()) {
    if (frame.getClass().getPackage().getName().startsWith("java"))
        continue;
    URL manifestURL = frame.getClass().getResource("/META-INF/MANIFEST.MF");
    // do something with the manifest
}