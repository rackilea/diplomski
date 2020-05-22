static String getArgs(String command, int argumentIndex)  {
    int start = 0;
    int end = -1;
    String delimiter = " ";
    for (int i = 0; i <= argumentIndex && !command.equals(""); i++)  {
        if (command.startsWith("\"")) {
            delimiter = "\"";
            start = 1;
        } else {
            delimiter = " ";
            start = 0;
        }

        end = command.indexOf(delimiter, start+1);
        if (i == argumentIndex)  {
            end = (end==-1?command.length():end);
            return command.substring(start, end).trim();    
        } else {
            end = (end==-1?command.length():end+1);
            command = command.substring(end).trim();
        }
    }
    return null;
 }