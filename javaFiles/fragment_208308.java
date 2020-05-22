Bundle bundle = Activator.getDefault().getBundle("com.your.plugin.name");
    if (bundle != null) {
        URL fileURL;
        try {
            fileURL = FileLocator.toFileURL(bundle.getEntry("/path/to/your/file/from/the/plugin/root"));
            String fileSystemPathToYourFile = fileURL.getPath());
        } catch (IOException exception) {
            // ...
        }
    }