try {
    final FileOutputStream stream = new FileOutputStream("path/to/file");

    try {
        final OutputStreamWriter writer = new OutputStreamWriter(stream);

        try {
            Decompiler.decompile(
                "java.lang.String",
                new PlainTextOutput(writer),
                DecompilerSettings.javaDefaults()
            );
        }
        finally {
            writer.close();
        }
    }
    finally {
        stream.close();
    }
}
catch (final IOException e) {
    // handle error
}