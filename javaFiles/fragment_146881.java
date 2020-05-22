package internal.secrets;

public final class SharedSecrets
{
    public static SharedSecrets INSTANCE = new SharedSecrets();
    public SecretCharacter secretCharacter;

    /**
     * Prevent construction.
     */
    private SharedSecrets()
    {
    }
}