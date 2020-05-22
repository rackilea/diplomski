public class Log {
    // utility class to keep logging code in one place
    public static void log (String message) {
        System.out.println(message);
        // when debugging at real device, S.o.p above can be refactored
        //  - based on ideas like one used here (with Form.append):
        //    http://stackoverflow.com/questions/10649974
        //  - Another option would be to write log to RMS
        //    and use dedicated MIDlet to read it from there
        //  - If MIDlet has network connection, an option is
        //    to pass log messages over the network. Etc etc...
    }
}


// ... other classes...
    // ...
    catch (Exception e) {
        Log.log("unexpected exception: [" + e + "]");
    }

    // ...
    public void commandAction(Command c, Displayable s) {
        Log.log("command: [" + c.getCommandLabel()
                + "] at screen: [" + d.getTitle() + "]");
        // ...
    }

    // ...
    Log.log("set current: [" + someDisplayable.getTitle() + "]");
    mydisplay.setCurrent(someDisplayable);
    // ...

    protected void keyPressed(int key) {
        Log.log("key pressed: [" + getKeyName(key) + "]");
        // ...
    }