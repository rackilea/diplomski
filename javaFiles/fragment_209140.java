protected void writeDirEntry(int id, DirectoryHandle dir, Buffer buffer, int index, Path f, String shortName, LinkOption... options) throws IOException {
   ...
    if (version == SFTP_V3) {
        // added shortName argument
        String longName = getLongName(f, options, shortName);
    } else {
    ...
}

// added shortName parameter
protected String getLongName(Path f, LinkOption... options, String shortName) throws IOException {
    // added shortName argument
    return getLongName(f, true, options, shortName);
}

// added shortName parameter
private String getLongName(Path f, boolean sendAttrs, LinkOption... options, String shortName) throws IOException {
    ...
    // added shortName argument
    return getLongName(f, attributes, shortName);
}

// added shortName parameter
private String getLongName(Path f, Map<String, ?> attributes, String shortName) throws IOException {
    ...
    return (SftpHelper.getBool(isDirectory) ? "d" : (SftpHelper.getBool(isLink) ? "l" : "-"))
            + PosixFilePermissions.toString(perms) + "  "
            + (attributes.containsKey("nlink") ? attributes.get("nlink") : "1")
            + " " + username + " " + group + " " + lengthString + " "
            + UnixDateFormat.getUnixDate((FileTime) attributes.get("lastModifiedTime"))
            // using shortName instead of getShortName(f) 
            + " " + shortName;
}

// + you need to modify sendPath to pass getShortName(f) 
//   to its call to getLongName