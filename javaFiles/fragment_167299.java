public class Enums{
    public enum Sex {
        MALE, FEMALE;

        public void info(){
            System.out.printf("I'm a %s.%n", this.toString().toLowerCase());
        }
    }

    public static void main(String[] argv){
        Sex a = Sex.MALE;
        Sex b = Sex.FEMALE;
        a.info();
        b.info();
    }
}