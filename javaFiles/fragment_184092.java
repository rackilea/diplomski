Class<?> tWCCamRes = tCLSLoader.loadClass("com.github.sarxos.webcam.WebcamResolution");
Field tVGA = tWCCamRes.getDeclaredField("VGA");
Object vgaFieldValue = tVGA.get(null); // it's a static field, so the argument of get() can be null.

Method tMeth = tVGA.getDeclaringClass().getDeclaredMethod("getSize");
tMeth.invoke(vgaFieldValue);