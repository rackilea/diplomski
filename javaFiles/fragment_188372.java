public static Object convertArgument(String arg) throws CoreException {
    if (arg == null) {
        return null;
    } else if (arg.length() == 0) {
        return arg;
    } else if (arg.charAt(0) == '\'' && arg.charAt(arg.length() - 1) == '\'') {
        return unEscapeString(arg.substring(1, arg.length() - 1));
    } else if ("true".equals(arg)) { //$NON-NLS-1$
        return Boolean.TRUE;
    } else if ("false".equals(arg)) { //$NON-NLS-1$
        return Boolean.FALSE;
    } else if (arg.indexOf('.') != -1) {
        try {
            return Float.valueOf(arg);
        } catch (NumberFormatException e) {
            return arg;
        }
    } else {
        try {
            return Integer.valueOf(arg);
        } catch (NumberFormatException e) {
            return arg;
        }
    }
}