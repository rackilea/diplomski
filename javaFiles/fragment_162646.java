public class BDateOptionHandler extends DateOptionHandler {
    @Override
    public int parseArguments(Parameters params) throws CmdLineException {
        try {
            super.parseArguments(params);
        }
        catch (CmdLineException e) {
            throw new ErrorCodeCmdLineException(2);
        }
    }
}

public class EDateOptionHandler extends DateOptionHandler {
    @Override
    public int parseArguments(Parameters params) throws CmdLineException {
        try {
            super.parseArguments(params);
        }
        catch (CmdLineException e) {
            throw new ErrorCodeCmdLineException(3);
        }
    }
}

...
try {
    parser.parseArgument(args);
} 
catch (CmdLineException e) {
    ...
    if (e instanceof ErrorCodeCmdLineException) {
        return ((ErrorCodeCmdLineException) e).getErrorCode();
    }
}