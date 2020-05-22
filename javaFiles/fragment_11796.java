public class CozaLozatest {

    public static void main(String[] args) {

        int result2 = 0;
        String n = JOptionPane.showInputDialog("Please input an interger");
        int result = Integer.parseInt(n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result; i++) {
            sb.append(" ");
            ++result2;
            if (result2 % 11 == 0)
                sb.append("\n");
            if (i % 3 == 0 && i % 5 == 0 && i % 7 == 0) {
                sb.append("CozaLozaWoza");
            } else if (i % 3 == 0 && i % 5 == 0) {
                sb.append("CozaLoza");
            } else if (i % 5 == 0 && i % 7 == 0) {
                sb.append("LozaWoza");
            } else if (i % 5 == 0) {
                sb.append("Loza");
            } else if (i % 3 == 0) {
                sb.append("Coza");
            } else if (i % 7 == 0) {
                sb.append("Woza");
            } else {
                sb.append(" " + i);
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}