public FSElement getTargetFromName (String targetName) throws CommandNotExecutedException {
    FSElement file = getTargetFromName(localroot, targetName);
    if (file == null) {
        throw new CommandNotExecutedException("Destination file/dir not found");
    }
    return file;
}