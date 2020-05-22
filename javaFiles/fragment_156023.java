/** filter stream for handling block data conversion */
private final BlockDataOutputStream bout;
/** obj -> wire handle map */
private final HandleTable handles;
/** obj -> replacement obj map */
private final ReplaceTable subs;
/** recursion depth */
private int depth;
/** buffer for writing primitive field values */
private byte[] primVals;