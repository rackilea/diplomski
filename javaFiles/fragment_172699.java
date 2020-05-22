public class Test{

    public static void main(String[] args){
        String data="+918033667777,,,2,,,4937015106932345,,,1,3,,,,467298364729038,,24789438292,,7979,,,,,,,1,,1";
        data = data.replaceAll("(?<=,)\\d(?=\\d{3,})|(?!\\A)\\G\\d", "*");
        System.out.println(data);
    }
}