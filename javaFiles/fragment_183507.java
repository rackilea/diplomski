@Override
public Connection close() {
    LOG.tracev( "Closing JDBC container [{0}]", this );
    if ( currentBatch != null ) {
    LOG.closingUnreleasedBatch();
        currentBatch.release();
    }
    cleanup();
    return logicalConnection.close();
}