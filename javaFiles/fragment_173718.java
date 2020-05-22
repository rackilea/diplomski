try(Writer writer = Files.newBufferedWriter(mOutputPath)) {
    mHashMap.forEach((key, value) -> {
        try { writer.write(key + DATA_SEPARATOR + value + System.lineSeparator()); }
        catch (IOException ex) { throw new UncheckedIOException(ex); }
    });
} catch(UncheckedIOException ex) { throw ex.getCause(); }