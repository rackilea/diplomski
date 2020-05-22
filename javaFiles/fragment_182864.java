public class TestSwing {
    public static void main(String[] args) {
        JLabel movies[] = new JLabel[20];
        for (int j = 0; j < movies.length; j++) {
            System.out.println("Loop Counter : " + j);
            movies[j].setText("Counter : " + j);
        }
    }
}