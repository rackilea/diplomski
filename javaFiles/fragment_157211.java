IMethod findMethod(IType type, String methodName) throws JavaModelException
{
    //IType type = project.findType(typeName);

    IMethod[] methods = type.getMethods();
    IMethod theMethod = null;

    for (int i = 0; i < methods.length; i++)
    {
        IMethod imethod = methods[i];
        if (imethod.getElementName().equals(methodName)) {
            theMethod = imethod;
        }
    }

    if (theMethod == null)
    {           
        System.out.println("Error, method" + methodName + " not found");
        return null;
    }

    return theMethod;
}