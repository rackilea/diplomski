/**
 * Invoked for a file that could not be visited.
 *
 * <p> Unless overridden, this method re-throws the I/O exception that prevented
 * the file from being visited.
 */
@Override
public FileVisitResult visitFileFailed(T file, IOException exc)
    throws IOException
{
    Objects.requireNonNull(file);
    throw exc;
}