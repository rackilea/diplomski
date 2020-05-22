static String getArgs(String command, int argumentIndex)  {
    int start = 0;
    int end = -1;

    for (int i = 0; i <= argumentIndex; i++)  {
        start = command.indexOf("\"", end+1)+1;
        end = command.indexOf("\"", start+1);

        if (i == argumentIndex)  {
            return command.substring(start, end);    
        }
    }

    return null;
 }