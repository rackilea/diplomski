Runtime rt = Runtime.getRuntime();
String[] processCommand = { "cmd", "/c", path };

try
{
    Process proc = rt.exec(processCommand);
    // ...
}