InputStream in;
try {
    in = context.openFileInput(filename);
    try {
        keyStore.load(in, password);
    } finally {
        in.close();
    }