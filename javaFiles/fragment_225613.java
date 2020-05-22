public class Settings {

    @NotEmpty
    private String[] allowableExtensions;

    @AssertTrue(message = "Each extension must be alphanumeric string with length {2,4}")
    public boolean isAssertTrue() {
        for ( String extension : allowableExtensions ) {
            if ( extension == null || extension.matches( "^[a-zA-Z0-9]{2,6}$" ) ) {
                return false;
            }
        }
        return true;
    }
}