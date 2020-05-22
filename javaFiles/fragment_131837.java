FileStatus fsStatus = fs.getFileStatus(stagingArea);
  String owner = fsStatus.getOwner();
  if (!(owner.equals(currentUser) || owner.equals(realUser))) {
     throw new IOException("The ownership on the staging directory " +
                  stagingArea + " is not as expected. " + 
                  "It is owned by " + owner + ". The directory must " +
                  "be owned by the submitter " + currentUser + " or " +
                  "by " + realUser);
  }
  if (!fsStatus.getPermission().equals(JOB_DIR_PERMISSION)) {
    LOG.info("Permissions on staging directory " + stagingArea + " are " +
      "incorrect: " + fsStatus.getPermission() + ". Fixing permissions " +
      "to correct value " + JOB_DIR_PERMISSION);
    fs.setPermission(stagingArea, JOB_DIR_PERMISSION);
  }