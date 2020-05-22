Dir findParent(Dir root, Dir d) {

    if (Arrays.asList(subdirs).contains(d))
        return this;

    for (Dir subdir : subdirs) {
        Dir parent = findParent(subdir, d);
        if (parent != null)
            return parent;
    }

    return null;
}