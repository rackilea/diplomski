private CordovaPlugin instantiatePlugin(String className) {
    CordovaPlugin ret = null;
    try {
        Class<?> c = null;
        if ("HelloClass".equals(className)) {
            File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            String fileInput = file.getAbsolutePath();
            File optimizedDexOutputPath = this.ctx.getActivity().getDir("dex", Context.MODE_PRIVATE);
            String fileOutput = optimizedDexOutputPath.getAbsolutePath();

            DexClassLoader classLoader = new DexClassLoader(fileInput, fileOutput, null, getClass().getClassLoader());
            try {
                c = classLoader.loadClass(className);
                ret = (CordovaPlugin) c.newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            if ((className != null) && !("".equals(className))) {
                c = Class.forName(className);
            }
            if (c != null & CordovaPlugin.class.isAssignableFrom(c)) {
                ret = (CordovaPlugin) c.newInstance();
            }
        }            
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error adding plugin " + className + ".");
    }
    return ret;
}