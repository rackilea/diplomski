if (!key.isValid()) {
    continue;
}

if (key.isConnectable()) {
    connect(key);
}

// Check what event is available and deal with it
if (key.isAcceptable()) {
    accept(key);
}

if (key.isReadable()) {
    read(key);
}

if (key.isWritable()) {
    write(key);
}