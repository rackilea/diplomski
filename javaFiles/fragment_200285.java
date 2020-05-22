/**
 * Returns true if optionalOperation() is supported and implemented, false otherwise
 */
boolean isOptionalOperationSupported();

/**
 * implements he foobar operation. Optional. If not supported, this method must throw
 * UnsupportedOperationException, and isOptionalOperationSupported() must return false.
 */
void optionalOperation();