private static final Pattern LSDRV_PATTERN = Pattern.compile("LS48.*\\.drv");
public boolean accept(File f) {
    if (f.isDirectory()) {
        return false;
    }

    return LSDRV_PATTERN.matcher().matches(f.getName());

}