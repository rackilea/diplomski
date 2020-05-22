while ((hidden == false) && (parentFile != null)) {
    // added the IF statement below:
    if (FileSystemUtils.isRoot(parentFile)) {
        hidden = false;
        break;
    }

    hidden = parentFile.isHidden();
    parentFile = parentFile.getParentFile();
}