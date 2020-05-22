// get the path
final Path path = Paths.get(...);
// get the attributes
final DosAttributes attrs = Files.readAttributes(path, DosFileAttributes.class);
// Is this file a "system file"?
final boolean isSystem = attrs.isSystem();