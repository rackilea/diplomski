private int secretSchmarr;

public boolean blammo()
{
    boolean returnValue;

    secretSchmarr = calculateSecretValue();

    returnValue = useSecretValue(secretSchmarr);

    secretSchmarr = 99; // this is not dead code.

    return returnValue;

    secretSchmarr = 98; // This is dead code because it can never execute.
}