import java.lang.String;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.function.Function;
import java.awt.Point;
import java.util.Scanner;

class Robot {

    public static void main(String args[]) {
        try(Scanner input = new Scanner(System.in)) {
            input.useDelimiter(",\\s*|\n");
            Robot r = new Robot();
            while(input.hasNext()) {
                try {
                    Command.parse(input.next().trim()).apply(r);
                } catch(NullPointerException e) {
                    System.out.printf("Syntax error.\n");
                } catch(RuntimeException e) {
                    System.out.printf("Can't go that way: %s.\n",
                        e.getMessage());
                }
            }
        } catch(Exception e) {
            System.err.printf("%s: %s.\n", e, e.getMessage());
        }
    }

    Point x;
    static Point dim;
    Command last;

    Robot() {
        dim = new Point(100, 500);
        x = new Point(5, 3);
    }

    enum Command {
        N("N", "north",  true,  (r) -> new Point(r.x.x, r.x.y - 1)),
        E("E", "east",   true,  (r) -> new Point(r.x.x + 1, r.x.y)),
        S("S", "south",  true,  (r) -> new Point(r.x.x, r.x.y + 1)),
        W("W", "west",   true,  (r) -> new Point(r.x.x - 1, r.x.y)),
        M("M", "farther",false, (r) -> r.last != null ?r.last.go.apply(r):null);

        private String command, name;
        private boolean isDir;
        private Function<Robot, Point> go;
        private static final Map<String, Command> map;

        /* Map for turning commands into Directions; mod->const map. */
        static {
            Map<String, Command> mod = new HashMap<>();
            for(Command c : values()) mod.put(c.command, c);
            map = Collections.unmodifiableMap(mod);
        }

        /** Called from definition of enum. */
        private Command(final String command, final String name, boolean isDir,
            final Function<Robot, Point> go) {
            this.command = command;
            this.name    = name;
            this.isDir   = isDir;
            this.go      = go;
        }

        /** @param str A string representing the direction.
         @return The command or null. */
        public static Command parse(final String str) { return map.get(str); }

        /** Applies this command to r. */
        public void apply(Robot r) {
            Point x = this.go.apply(r);
            if(x == null)
                throw new RuntimeException("don't have a direction");
            if(x.x < 0 || x.x >= dim.x || x.y < 0 || x.y >= dim.y)
                throw new RuntimeException("at the edge");
            r.x = x;
            if(this.isDir == true) r.last = this;
            System.out.printf("Went %s to (%d, %d).\n", r.last.name, x.x, x.y);
        }

        /** @return The name of the direction. */
        public String toString() { return name; }
    }

}