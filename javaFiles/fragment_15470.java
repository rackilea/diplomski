catch ( Exception e ) {
    if (haltOnError) {
        throw new ImportScriptException( "Error during statement execution (file: '"
                + namedReader.getName() + "'): " + trimmedSql, e );
    }
    exceptions.add(e);
    LOG.unsuccessful(trimmedSql);
    LOG.error(e.getMessage());
}