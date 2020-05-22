public class Main {
    public static void main(String[] argv) {
        String input = "gudmor,ningeveryone,Have a great day,thankssssssssssss";
        String[] firstSplit = input.split(",");
        List<String> result = new ArrayList<>();
        String[] tmpArray;
        for (String elem : firstSplit) {
            if (elem.length() <= 10) {
                result.add(elem);
            } else {
                for(int i = 0;i < elem.length()/10;i++) {
                    result.add(elem.substring(i*10,(i+1)*10));
                }
                if(elem.length() % 10 != 0) {
                    result.add(elem.substring(elem.length() - (elem.length() % 10)));
                }
            }
        }
    }
}