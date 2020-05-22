private FSElement getTargetFromName (FSElement root, String targetName) {
        Iterator<FSElement> children = root.iterator();
        while (children.hasNext()) {
            FSElement child = children.next();
            if (child.getName().equals(targetName)) {
                return child;
            } else if (child.isDirectory()) {
                FSElement searched = getTargetFromName(child, targetName);
                if (searched != null) {
                    return searched;
                }
            }
        }
        return null;
    }