if (parent.isChildDirectory(path[0])) {
    String[] newPath = Arrays.copyOfRange(path, 1, path.length);
    Directory newParent = parent.getChildDirectory(path[0]);
    return FileSystem.makePath(newParent, newPath);
}
// If dir does not exist, create it and then go into the next level
else {
    parent.addDirectory(path[0]);
    String[] newPath = Arrays.copyOfRange(path, 1, path.length);
    Directory newParent = parent.getChildDirectory(path[0]);
    return FileSystem.makePath(newParent, newPath);
}