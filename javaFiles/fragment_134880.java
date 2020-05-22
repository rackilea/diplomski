import java.applet.*;
public class Test extends Applet {
    String data[][];
    public void init() {
        data = new String[5][2];
        data[0] = new String[] { "Peter", "Griffin"};
        data[1] = new String[] { "Glen", "Quagmire"};
        data[2] = new String[] { "Joe", "Something"};
        data[3] = new String[] { "Cleveland", "Brown"};
        data[4] = new String[] { "Buzz", "Killington"};
    }

    public String getData() {
        return toJSON(data);
    }

    /* Quick and dirty, you may want to look
    * online for a 'complete' converter
    *
    * This returns [["Peter", "Griffin"], ["Glen", "Quagmire"], ... etc
    */
    protected String toJSON(String data[][]) {
        int x, y;
        String s = "[";
        for (y = 0;y < data.length;y += 1) {
            s += "[";
            for (x = 0;x < data[y].length;x += 1) {
                s += "\""+data[y][x].replaceAll("\"","\\\"")+"\"";
                if (x < data[y].length-1) {
                    s += ", ";
                }
            }
            s += "]";
            if (y < data.length-1) {
                s += ", ";
            }
        }
        s += "]";

        return s;
    }
}