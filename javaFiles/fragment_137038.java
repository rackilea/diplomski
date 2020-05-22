float[] floats = readFile();

// Convert to little-endian doubles
ByteBuffer bb = ByteBuffer.allocateDirect(4 * floats.length);
bb.order(ByteOrder.LITTLE_ENDIAN);
DoubleBuffer db = bb.asDoubleBuffer();
for (int i = 0; i < floats.length; ++ i) {
    db.put(i, floats[i]);
}

doImageProcessing(bb); // Native method

// Convert double values to ARGB
int j = 0;
int[] argb = new int[floats.length / 4];
for (int i = 0; i < floats.length; i += 4) {
    int a = Math.max(0, Math.min((int) (db.get(i) * 256.0), 255));
    int r = Math.max(0, Math.min((int) (db.get(i+1) * 256.0), 255));
    int g = Math.max(0, Math.min((int) (db.get(i+2) * 256.0), 255));
    int b = Math.max(0, Math.min((int) (db.get(i+3) * 256.0), 255));
    argb[j++] = (a<<24)|(r<<16)|(g<<8)|b;
}