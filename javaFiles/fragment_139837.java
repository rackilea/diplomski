// simple but probably not a good idea.
public String send(String message) {
    out.println(message);
    try {
        while(true) {
            String line = in.readLine();
            if (isEvent(line))
               processEvent(line);
            else
               return line;
    } catch (IOException ex) {
        return "";
    }
}