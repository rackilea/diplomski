import javax.swing.JOptionPane;

public class Guess_The_Color {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        sb.append("<html>");
        sb.append("<table><tr><th>Name</th><th>Class</th><th>Roll No.</th></tr>");
        sb.append("<tr><td>Arvind</td><td>10</td><td>1</td></tr>");
        sb.append("<tr><td>Kumar</td><td>9</td><td>2</td></tr>");
        sb.append("<tr><td>Avinash</td><td>8</td><td>3</td></tr>");
        sb.append("</table>");
        sb.append("</html>");
        JOptionPane.showMessageDialog(null,sb.toString());
    }
}