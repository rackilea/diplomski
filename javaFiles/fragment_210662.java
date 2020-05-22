public enum LoginResponse
{

    WRONG_PASSWORD("Wrong Password", false),
    WRONG_USERNAME("Wrong Username", false),
    SUCCESS("Successfully logged in.", true);

    private String message;
    private boolean success;

    private LoginResponse(String message, boolean success)
    {
        this.message = message ;
        this.success = success;
    }

    public String toString()
    {
        return this.success + ": " + this.message;
    }
}