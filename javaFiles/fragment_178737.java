public class TSTAFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        return f.getName().startsWith("TSTA");
    }

    @Override
    public String getDescription() {
        return "Only files starting with TSTA";
    }
}