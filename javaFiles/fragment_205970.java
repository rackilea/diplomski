try
{
    System.setProperty(JAVA_LIBPATH_PROPNAME, libpath);  
    ForceReloadLibraryPath();
    System.loadLibrary("AdsToJava");        
}
catch (UnsatisfiedLinkError ex)
{
    // We simply did not find the dll
    if (ex.getMessage().equals("no MyLibrary in java.library.path")) {

        // Just alert that nothing was found

    } else if ( (ex.getMessage().endsWith("Can't load IA 32-bit .dll on a AMD 64-bit platform")) || 
                (ex.getMessage().endsWith("Can't load AMD 64-bit .dll on a IA 32-bit platform")) ) {

        // Extract the path at which the dll whith the wrong bitness was found 
        // and remove it from the search path and try again
    }
}