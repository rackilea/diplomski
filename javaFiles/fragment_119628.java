// Do this once:
CodedInputStream cis = CodedInputStream.newInstance(input);

// Then read each message like so:
int limit = cis.pushLimit(cis.readRawVarint32());
builder.mergeFrom(cis);
cis.popLimit(limit);
cis.resetSizeCounter();