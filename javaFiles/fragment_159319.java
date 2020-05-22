public FileNode findChild(String name) {
    FileNode result = null;
        for (FileNode child : this.getChildren()) {
            if (child.getName() == name) {
                result = child;
                break;
            } else {
                result = child.findChild(name);
                if (result != null)
                    break;
            }
        }
    return result;
}