@Override
public void checkPackageAccess(String pkg){

    // don't allow the use of the reflection package
    if(pkg.equals("java.lang.reflect")){
        throw new SecurityException("Reflection is not allowed!");
    }
}