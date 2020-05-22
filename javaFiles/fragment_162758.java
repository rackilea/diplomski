public static void executeSecureCommand(final String user,
                                        final String remoteHost,
                                        final String command)
{
    // basic validation of the parameters
    if ((user == null) || user.isEmpty())
    {
        // log the error and throw an exception
        String errorMessage = "Error executing the ssh command \'" + command +
                              "\': the supplied user name parameter is null or empty.";
        log.error(errorMessage);
        throw new LifecycleException(errorMessage);
    }
    if ((remoteHost == null) || remoteHost.isEmpty())
    {
        // log the error and throw an exception
        String errorMessage = "Error executing the ssh command \'" + command +
                              "\': the supplied remote host parameter is null or empty.";
        log.error(errorMessage);
        throw new LifecycleException(errorMessage);
    }
    if ((command == null) || command.isEmpty())
    {
        // log the error and throw an exception
        String errorMessage = "Error executing the ssh command: the supplied command parameter is null or empty.";
        log.error(errorMessage);
        throw new LifecycleException(errorMessage);
    }

    // create and execute a corresponding ssh command
    String sshCommand = "ssh " + user + "@" + remoteHost + " " + command;
    try
    {
        executeShellCommand(sshCommand);
    }
    catch (Exception ex)
    {
        // log the error and throw an exception
        String errorMessage = "Error executing the secure shell command \'" + sshCommand + "\'";
        log.error(errorMessage, ex);
        throw new LifecycleException(errorMessage, ex);
    }
}

public static void executeSecureFileCopy(final String localFilePathName,
                                         final String user,
                                         final String remoteHost,
                                         final String remoteFilePathName)
{
    // basic validation of the parameters
    if ((localFilePathName == null) || localFilePathName.isEmpty())
    {
        // log the error and throw an exception
        String errorMessage = "Error executing the secure copy -- the supplied local file path name parameter is null or empty.";
        log.error(errorMessage);
        throw new LifecycleException(errorMessage);
    }
    if ((user == null) || user.isEmpty())
    {
        // log the error and throw an exception
        String errorMessage = "Error executing the secure copy -- the supplied user name parameter is null or empty.";
        log.error(errorMessage);
        throw new LifecycleException(errorMessage);
    }
    if ((remoteHost == null) || remoteHost.isEmpty())
    {
        // log the error and throw an exception
        String errorMessage = "Error executing the secure copy -- the supplied remote host parameter is null or empty.";
        log.error(errorMessage);
        throw new LifecycleException(errorMessage);
    }
    if ((remoteFilePathName == null) || remoteFilePathName.isEmpty())
    {
        // log the error and throw an exception
        String errorMessage = "Error executing the secure copy -- the supplied remote file path name parameter is null or empty.";
        log.error(errorMessage);
        throw new LifecycleException(errorMessage);
    }

    try
    {
        // create an scp command we'll use to perform the secure file copy
        String scpCommand = "scp -B -C -q " + localFilePathName + " " + user + "@" + remoteHost + ":" +
                            remoteFilePathName;

        // execute the scp command
        executeShellCommand(scpCommand);
    }
    catch (Exception ex)
    {
        // log the error and throw an exception
        String errorMessage = "Failed to copy local file \'" + localFilePathName + "\' to remote host:file \'" +
                              remoteHost + ":" + remoteFilePathName + "\'.";
        log.error(errorMessage, ex);
        throw new LifecycleException(errorMessage, ex);
    }
}

public static void executeShellCommand(final String command)
{
    try
    {
        // create and execute a runtime process which runs the command
        Process process = Runtime.getRuntime().exec(new String[] { "/bin/sh", "-c", command });

        // gobble the input stream
        InputStream processInputStream = process.getInputStream();
        BufferedReader processInputStreamReader = new BufferedReader(new InputStreamReader(processInputStream));
        String inputStreamLine = processInputStreamReader.readLine();
        while (inputStreamLine != null)
        {
            inputStreamLine = processInputStreamReader.readLine();
        }

        // capture the error stream
        InputStream processErrorStream = process.getErrorStream();
        BufferedReader processErrorStreamReader = new BufferedReader(new InputStreamReader(processErrorStream));
        String errorStreamLine = processErrorStreamReader.readLine();
        StringBuffer errorBuffer = new StringBuffer();
        while (errorStreamLine != null)
        {
            errorBuffer.append(errorStreamLine);
            errorStreamLine = processErrorStreamReader.readLine();
        }

        // close the streams
        processInputStream.close();
        processErrorStream.close();

        // wait for the process to finish and return the exit code
        process.waitFor();
        if (process.exitValue() != 0)
        {
            // log the error and throw an exception
            String errorMessage = "Failed to execute the shell command \'" + command + "\' -- Error: \'" +
                                  errorBuffer.toString() + "\'";
            log.error(errorMessage);
            throw new LifecycleException(errorMessage);
        }
    }
    catch (Exception ex)
    {
        // log the error and throw an exception
        String errorMessage = "Failed to execute the shell command \'" + command + "\'.";
        log.error(errorMessage, ex);
        throw new LifecycleException(errorMessage, ex);
    }
}