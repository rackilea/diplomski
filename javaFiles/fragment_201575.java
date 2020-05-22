buffer.append("void "); //$NON-NLS-1$
        buffer.append(methodName);
        buffer.append("() throws "); //$NON-NLS-1$
        buffer.append(imports.addImport("java.lang.Exception")); //$NON-NLS-1$
        buffer.append(" {}"); //$NON-NLS-1$
        buffer.append(delimiter);