if (NativeCodeLoader.isNativeCodeLoaded()) {
    this.impl = new JniBasedUnixGroupsMapping();
} else {
    LOG.info("Falling back to shell based");
    this.impl = new ShellBasedUnixGroupsMapping();
}