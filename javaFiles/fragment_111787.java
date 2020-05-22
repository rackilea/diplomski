//this variable's value assigned by iterating through context.getPackageManager().getInstalledApplications(0)
ApplicationInfo pkg; 

String interfaceTheyShouldntHave = ExternalPluginVX.class.getCanonicalName(); //"com.project.external.ExternalPluginVX"
DexFile dexFile = new DexFile(pkg.sourceDir);
Enumeration<String> entries = dexFile.entries();
while(entries.hasMoreElements()){
    String entry = entries.nextElement();
    if(entry.equals(interfaceTheyShouldntHave)){
        Toast.makeText(ctxt, "Plugin \"" + pluginName + "\" could not be loaded. Please use 'provided files' instead of 'compile files'", Toast.LENGTH_LONG).show();
        return;
    }
}