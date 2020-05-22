// Java program implementing Singleton class
// with getInstance() method
class Singleton {
    // static variable single_instance of type Singleton
    private static Singleton single_instance_first = null;
    private static Singleton single_instance_second = null;
    private static Singleton single_instance_third = null;

    // variable of type String
    public String s;

    // private constructor restricted to this class itself
    private Singleton() {
        s = "Hello I am a string part of Singleton class";
    }

    // static method to create instance of Singleton class
    public static Singleton getInstance(int index) {
        switch (index) {
            case 0: {
                if (single_instance_first == null)
                    single_instance_first = new Singleton();
                return single_instance_first;
            }
            case 1: {
                if (single_instance_second == null)
                    single_instance_second = new Singleton();
                return single_instance_second;
            }
            case 2: {
                if (single_instance_third == null)
                    single_instance_third = new Singleton();
                return single_instance_third;
            }
            default: {
                if (single_instance_first == null)
                    single_instance_first = new Singleton();
                return single_instance_first;
            }
        }
    }
}