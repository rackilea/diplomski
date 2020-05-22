public class WildcardExclusionFilter extends WildcardFileFilter implements FileFilter
{
    public WildcardExclusionFilter(String glob)
    {
        super(glob);
    }

    @Override
    public boolean accept(File file)
    {
        // Return the Opposite of what the wildcard file filter returns,
        // to *exclude* matching files and *include* anything else.
        return ! super.accept(file);
    }
}