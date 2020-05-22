import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

public class Main {

    public static class MySource {

        // a -> a
        private String a;

        // getB() -> b
        private String hidden_b;
        public String getB() { return hidden_b; }

        // c -> setC(c)
        private String c;

        // getD() -> setD(d)
        private String hidden_d;

        // proper getters and setters on both sides
        private String proper;
        public String getProper() { return proper; }
        // public void setProper(String proper_) { proper = proper_; }

        public MySource() {
            a = "A Room with a View";
            hidden_b = "The Bridge of San Luis Rey";
            c = "Civilwarland in Bad Decline";
            hidden_d = "Darkness at Noon";
            proper = "This should copy, at minimum.";
        }

        public void print() {
            System.out.println("Source");
            System.out.println("================================");
            System.out.println("a        = " + a);
            System.out.println("hidden_b = " + hidden_b);
            System.out.println("c        = " + c);
            System.out.println("hidden_d = " + hidden_d);
            System.out.println("--------------------------------");
            System.out.println("proper   = " + proper);
            System.out.println("");
        }
    }

    public static class MyTarget {

        private String a;
        private String b;
        private String hidden_c;
        private String hidden_e;

        public void setC(String param) { hidden_c = param; }
        public void setD(String param) { hidden_e = param; }

        private String proper;
        // public String getProper() { return proper; }
        public void setProper(String proper_) { proper = proper_; }

        public MyTarget() {}

        public void print() {
            System.out.println("Target");
            System.out.println("================================");
            System.out.println("a        = " + a);
            System.out.println("b        = " + b);
            System.out.println("hidden_c = " + hidden_c);
            System.out.println("hidden_e = " + hidden_e);
            System.out.println("--------------------------------");
            System.out.println("proper   = " + proper);
            System.out.println("");
        }
    }

    public static void main(String args[]) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
            .setFieldMatchingEnabled(true)
            .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        MySource s = new MySource();
        s.print();

        System.out.println("Now dozing...");
        System.out.println("");

        MyTarget t = modelMapper.map(s, MyTarget.class);
        t.print();
    }
}