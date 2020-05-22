if (!parent.isChildDirectory(path[0])) {
    parent.addDirectory(path[0]);
}
String[] newPath = Arrays.copyOfRange(path, 1, path.length);
Directory newParent = parent.getChildDirectory(path[0]);
return FileSystem.makePath(newParent, newPath);