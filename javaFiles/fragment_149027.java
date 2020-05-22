460     /**
  461      * If true, the appender will generate the HEADER part (that is, timestamp and host name)
  462      * of the syslog packet.  Default value is false for compatibility with existing behavior,
  463      * however should be true unless there is a specific justification.
  464      * @since 1.2.15
  465     */
  466     public final boolean getHeader() {
  467         return header;
  468     }
  469   
  470       /**
  471        * Returns whether the appender produces the HEADER part (that is, timestamp and host name)
  472        * of the syslog packet.
  473        * @since 1.2.15
  474       */
  475     public final void setHeader(final boolean val) {
  476         header = val;
  477     }