String[] osNames = { "Win7.32bit", "Win7.64bit", "10.04" };
String[] osTypes = { "Win7.32bit", "Win7.64bit", "ubuntu10.04" };
for (int i = 0; i < Math.min(osNames.length, osTypes.length); i++) {
    if (OS.contains(osName[i])) {
        url = prefix + osType[i] + suffix;
        if (size.contains("origin")) {
            url = prefixLarge + osType[i] + suffix;
        }
        break;
    }
}