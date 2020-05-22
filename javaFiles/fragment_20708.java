import java.io.File;
import java.nio.file.InvalidPathException;
public class Test {
    public static final void main(final String[] args) {
        final String current = new File(".").toPath().toAbsolutePath().normalize().toFile().toString();
        Test.correctPath(current);
        Test.correctPath(current + "aValidExpression");
        Test.correctPath(current + "aValidExpression?;:-&é");
        Test.correctPath(current + "aValidExpr//ession?;:-&é");
        Test.correctPath(current + "aValidExpre\\ssion?;:-&é");
    }

    public static final String correctPath(final String path) {
        try {
            final String returnValue = new File(path).toPath().toAbsolutePath().normalize().toFile().toString();
            System.out.println(returnValue);
            return returnValue;
        } catch (final InvalidPathException e) {
            System.err.println(e.getMessage());
            final int errorIndex = e.getIndex();
            final String newPath = path.substring(0, errorIndex - 1) + path.substring(errorIndex + 1);
            return Test.correctPath(newPath);
        }
    }
}