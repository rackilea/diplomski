Path file = ...;  
Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-------");  
FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);  
try {  
    Attributes.setPosixFilePermissions(file, perms);  
} catch (IOException x) {  
    System.err.println(x);  
}