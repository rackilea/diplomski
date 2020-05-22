import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class StringDemo {

    public static void main(String arg[]){

        StringBuilder buff = new StringBuilder();
        buff.append("<html><table>");
        buff.append(String.format("<tr><td align='right'>%s</td><td>:</td><td>%s</td></tr>", "Hoffenheim  1", "0  Koeln"));
        buff.append(String.format("<tr><td align='right'>%s</td><td>:</td><td>%s</td></tr>", "Bayern  2", "1  HSV"));
        buff.append("</table></html>");

        JOptionPane.showMessageDialog(null, new JLabel(buff.toString()));
    }
}