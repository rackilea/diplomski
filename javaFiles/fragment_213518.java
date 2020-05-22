final DecompilerSettings settings = DecompilerSettings.javaDefaults();

try (final FileOutputStream stream = new FileOutputStream("path/to/file");
     final OutputStreamWriter writer = new OutputStreamWriter(stream)) {

    Decompiler.decompile(
        "java.lang.String",
        new PlainTextOutput(writer),
        settings
    );
}
catch (final IOException e) {
    // handle error
}