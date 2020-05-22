// lowercase "interface"
// Usually interfaces and classes are capitalized
public interface Operations{
    // Singular to match the rest of the code and question.
    public static enum ErrorCode{
        // commas to separate instances
        BADFD,
        NOFILE,
        ISDIR;
        // Parameterless constructor needs ()
        private ErrorCode() {
        }
    }
}