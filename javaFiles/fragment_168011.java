public class Splitter {

    public static void main(String[] args) {
        String values = "1 Ola Hansen Timoteivn Sandnes\n"
                + "2 Tove Svendson Borgvn Stavanger\n"
                + "3 Kari Pettersen Storgt Stavanger";
        String[] rows = values.split("\n");
        for (String row : rows) {
            String[] fields = row.split(" ");
            System.out.println(String.format("id: %s firstname: %s lastname: %s street: %s city %s", fields[0], fields[1], fields[2], fields[3], fields[4]));
        }
    }
}