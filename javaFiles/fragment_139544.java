delete

public boolean delete()
Deletes the file or directory denoted by this abstract pathname. If this pathname
denotes a directory, then the directory must be empty in order to be deleted.
Returns:
true if and only if the file or directory is successfully deleted; false otherwise
Throws:
SecurityException - If a security manager exists and its SecurityManager.checkDelete(java.lang.String) method denies delete