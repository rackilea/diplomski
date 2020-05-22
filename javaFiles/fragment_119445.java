Context context = ...;
RenderScript renderScript = RenderScript.create(context);

Bitmap bitmap = ...; // A random bitmap
Allocation allocationBitmap = Allocation.createFromBitmap(renderScript, bitmap);
Allocation allocationCount = Allocation.createTyped(renderScript, Type.createX(renderScript, Element.I32(renderScript), 1));

ScriptC_Counter script = new ScriptC_Counter(renderScript);
script.set_rsAllocationCount(allocationCount);
script.forEach_countPixels(allocationBitmap);

int[] count = new int[1];
allocationBitmap.syncAll(Allocation.USAGE_SCRIPT);
allocationCount.copyTo(count);

// The count can now be accessed via
count[0];