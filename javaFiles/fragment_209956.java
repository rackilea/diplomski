String old = readOld();
char backSlash = '\\';
String newConfig = old.replaceAll(old,
    "[HKEY_CURRENT_USER" + backSlash + backSlash + "Software"
    + backSlash + backSlash + "xxxx"
    + backSlash + backSlash + "xxxx"
    + backSlash + backSlash + "Config]");