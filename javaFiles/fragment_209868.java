List<Float> floatList = getItSomehow();
float[] floatArray = new float[floatList.size()];
int i = 0;

for (Float f : floatList) {
    floatArray[i++] = (f != null ? f : Float.NaN); // Or whatever default you want.
}