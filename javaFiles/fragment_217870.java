public class test {

    public static void main(String[] args) {
        WinsFileManager manager = new WinsFileManager();
        String fileName = "O Wins.txt";

        manager.saveWins(fileName, 5);
        System.out.println(manager.getWins(fileName));
    }
}