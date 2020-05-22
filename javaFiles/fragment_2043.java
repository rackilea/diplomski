public String getSourceBase(Class<?> classx)
{
    String cn = classx.getName().replace('.', '/') + ".class";
    // like "packagex/SourceBase.class"

    String s = classx.getResource('/' + cn).toExternalForm();
    // like "file:/javadir/Projects/projectX/build/classes/packagex/SourceBase.class"
    // or "jar:file:/opt/java/PROJECTS/testProject/dist/testProject.jar!/px/SourceBase.class"

    return s.substring(0, s.lastIndexOf(cn));
    // like "file:/javadir/Projects/projectX/build/classes/"
    // or "jar:file:/opt/java/PROJECTS/testProject/dist/testProject.jar!/"

}