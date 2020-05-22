public class NewMain {

    public static void main(String[] args) {

        try {

            ObjectMapper mapper = new ObjectMapper();

            mapper.writeValue(new File("/parameter.json"), new YourObject(1, "some string", "another string"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class YourObject {

    private int a;
    private String b;
    private String c;

    public YourObject(int a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }