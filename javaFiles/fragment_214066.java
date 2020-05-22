public class TestRegex {
    public static void main(String[] args) {
        String str = "<item value=\"key\" atr='none'><date><date><title val=\"has value\">Good</title><link>www</link></item><item value=\"key\" atr='none'><title val=\"has value\">Bad</title><link>http</link><author></author></item><item value=\"key\" atr='none'><title val=\"has value\">Neutral</title><link>ftp</link></item>";

        Pattern pattern = Pattern.compile("<item.*?>(.*?)<\\/item>");

        Matcher match = pattern.matcher(str);

        while(match.find()) {
            System.out.println(match.group(1));
        }
    }
}