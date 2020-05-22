/**
 * Return the {@link File} to use to backup the original source.
 * @return the file to use to backup the original source
 */
public final File getBackupFile() {
    return new File(this.source.getParentFile(), this.source.getName() + ".original");
}