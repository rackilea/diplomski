String[] lines = info.split("\r?\n"); // Split on line end
if (lines.length != properties.length + 1) {
    return false;
}

for (int lineno = 0; lineno < properties.length; ++lineno) {
    if (!lines[lineno].startsWith(properties[lineno] + ":")) {
        return false;
    }
}

String values = ... and the rest using split("\\s+").