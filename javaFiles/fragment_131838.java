FileStatus fsStatus = fs.getFileStatus(stagingArea);
  String owner = fsStatus.getOwner();
  if (!(owner.equals(currentUser) || owner.equals(realUser)) || 
      !fsStatus.getPermission().equals(JOB_DIR_PERMISSION)) {
     throw new IOException("The ownership/permissions on the staging " +
                  "directory " + stagingArea + " is not as expected. " + 
                  "It is owned by " + owner + " and permissions are "+ 
                  fsStatus.getPermission() + ". The directory must " +
                  "be owned by the submitter " + currentUser + " or " +
                  "by " + realUser + " and permissions must be rwx------");
  }