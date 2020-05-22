public class Test {

    public static void main(String[] args) {
        String str = "+d+=3=+s+";
        System.out.println(str);

        str = str.replaceAll("[^a-zA-Z]", "");
        System.out.println(str);
        System.out.println("count "+str.length());
    }

}