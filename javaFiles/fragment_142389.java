public class Example {

    public static void main(String [] args) {
        String str ="abdcfghaasdfaadftaxvvaacvbtradcea";
        System.out.println(countChr(str));

        String str2 ="abdcfAhaasdAaadftaxvAAAacvbtradcea";
        System.out.println(countChr(str2));
    }

    static int countChr(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int count = 0;
        if (str.substring(0, 1).equals("A")) {
            count = 1;
        }
        return count + countChr(str.substring(1));
    }
}