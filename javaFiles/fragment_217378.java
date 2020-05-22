public final void appendMessage( final String message ) {
    try {
        ExcerptAppender writer = chronicle.createAppender();
        writer.startExcerpt( STRING_SIZE_OVERHEAD + message.length() );
        writer.append( message );
        writer.finish();
    } catch( Exception e ) {
        LOGGER.warn("Failed to persist Message [{}]", message );
        LOGGER.warn("Exception: ", e );
    }
}