public static File newFile(String root, String... parts) {
    // TODO: Check that nothing's null (root, parts, each element of parts)
    File ret = new File(root);
    for (String part : parts) {
        ret = new File(ret, part);
    }
    return ret;
}