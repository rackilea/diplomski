import org.eclipse.jdt.core.Signature;

private static String getMethodFullName(IMethod iMethod)
{
        StringBuilder name = new StringBuilder();
        name.append(iMethod.getDeclaringType().getFullyQualifiedName());
        name.append(".");
        name.append(iMethod.getElementName());
        name.append("(");

        String comma = "";
        String[] parameterTypes = iMethod.getParameterTypes();
        try {
            String[] parameterNames = iMethod.getParameterNames();
            for (int i=0; i<iMethod.getParameterTypes().length; ++i) {
                name.append(comma);
                name.append(Signature.toString(parameterTypes[i]));
                name.append(" ");
                name.append(parameterNames[i]);
                comma = ", ";
            }
        } catch (JavaModelException e) {
        }

        name.append(")");

        return name.toString();
}