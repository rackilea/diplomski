command = kb.nextline();
String newline = System.getProperty("line.separator");
boolean hasNewline = command.contains(newline);
if(!hasNewline)
{
    performProcess(command);
}