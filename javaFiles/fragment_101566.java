/**
 * Create a Configuration based on the environment variables.
 *
 * @see System#getenv()
 */
public EnvironmentConfiguration()
{
    super(new HashMap<String, Object>(System.getenv()));
}