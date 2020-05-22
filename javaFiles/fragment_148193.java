List<Integer> invalidIndices = new LinkedList<Integer>();

String invalidChars;
if (OS.isWindows()) {
    invalidChars = "\\/:*?\"<>|";
} else if (OS.isMacOSX()) {
    invalidChars = "/:";
} else { // assume Unix/Linux
    invalidChars = "/";
}

char[] chars = filename.toCharArray();
for (int i = 0; i < chars.length; i++) {
    if ((invalidChars.indexOf(chars[i]) >= 0) // OS-invalid
        || (chars[i] < '\u0020') // ctrls
        || (chars[i] > '\u007e' && chars[i] < '\u00a0') // ctrls
    ) {
        invalidIndices.add(i);
    }
}

return invalidIndices;