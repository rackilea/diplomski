try {
    OperationSetBasicTelephonyJabberImpl basicTelephony = 
                new OperationSetBasicTelephonyJabberImpl(this); 
} catch (Throwable t) {
    logger.info(t.getStackTrace());
} finally {
    // The rest...
}