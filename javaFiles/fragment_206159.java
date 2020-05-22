public static final SecurityManager NON_EXITABLE_MANAGER = new SecurityManager(){

    @Override
    public void checkPermission(Permission perm) {
        //allow everything
    }
    /**
     * Throws a {@link TriedToExitException} instead of exiting.
     * <p/>
     * {@inheritDoc}
     */
    @Override
    public void checkExit(int status) {
        throw new TriedToExitException(status);
    }

};

public static final class TriedToExitException extends SecurityException{
    private static final long serialVersionUID = 1L;
    private final int exitCode;

    public TriedToExitException(int exitCode){
        this.exitCode=exitCode;
    }

    @Override
    public String getMessage() {
        return String.format("tried to System.exit(%d)",exitCode);
    }

    public int getExitCode() {
        return exitCode;
    }

}