float[] floatFeatures = {0.4f, 0.8f, 0.3f, 0.3f, 0.1f, 0.5f, 0.4f, 0.8f, 0.3f, 0.3f} ;
String[] catFeatures = {"1", "2", "3", "4"};

final Pointer pFloatFeatures = new Memory(floatFeatures.length * Native.getNativeSize(Float.TYPE));
final Pointer[] ppFloatFeatures = new Pointer[2];
for (int dloop=0; dloop<10; dloop++) {
    pFloatFeatures.setFloat(dloop * Native.getNativeSize(Float.TYPE), floatFeatures[dloop]);
}
ppFloatFeatures[0] = pFloatFeatures;
ppFloatFeatures[1] = pFloatFeatures;

final Pointer[] ppCatFeatures = new Pointer[catFeatures.length];
final Pointer pCatFeatures = new StringArray(catFeatures);
ppCatFeatures[0] = pCatFeatures;
ppCatFeatures[1] = pCatFeatures;