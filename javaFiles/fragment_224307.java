public void saveCurrentList () {
    File tempCurrentFile = new File ( currentFile.toString() + ".temp" );
    try ( ObjectOutputStream currentListOut = new ObjectOutputStream( new FileOutputStream( tempCurrentFile ) ) ) {
        currentListOut.writeObject( player.getCurrentList().getState() );
        currentListOut.flush();
        currentListOut.close();

        Files.move( tempCurrentFile.toPath(), currentFile.toPath(), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE );

    } catch ( Exception e ) {
        LOGGER.warning( e.getClass().getCanonicalName() + ": Unable to save current list to disk, continuing." );
    }
}