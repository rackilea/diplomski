/* initialize once */
    FilePool.setLimit (maxFiles);

    /* called often */
    FilePool.getFile(ident);
    FilePool.closeFile(handle);

    /* protected/internal/… */
    boolean FilePool.reachedLimit ();
    FilePool.closeLeastRecentlyUsed (number);
    OnTimer → FilePool.closeIdleFiles (duration);