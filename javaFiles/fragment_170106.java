static final String REG_ADD_CMD = "cmd /c reg add \"HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run\" /v \"{0}\" /d \"{1}\" /t REG_EXPAND_SZ";
private void exec(String[] args) throws Exception
{
    if (args.length != 2)
        throw new IllegalArgumentException("\n\nUsage: java SetEnv {key} {value}\n\n");

    String key = args[0];
    String value = args[1];

    String cmdLine = MessageFormat.format(REG_ADD_CMD, new Object[] { key, value });

    Runtime.getRuntime().exec(cmdLine);
}