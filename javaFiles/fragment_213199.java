import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.ArrayList;
import java.io.*;

public class MapEditor {

    String map
            = "10100101\n"
            + "10010101\n"
            + "11011101\n"
            + "11000001";

    public int[][] readMapFromString() throws IOException {
        ArrayList<String> mapStrings = new ArrayList();
        ByteArrayInputStream bais = new ByteArrayInputStream(map.getBytes());
        InputStreamReader isr = new InputStreamReader(bais);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        while (s != null) {
            mapStrings.add(s);
            s = br.readLine();
        }
        int h = mapStrings.get(0).length();
        int w = mapStrings.size();
        int[][] map = new int[w][h];
        for (int ii=0; ii<w; ii++) {
            s = mapStrings.get(ii);
            for (int jj = 0; jj<h; jj++) {
                map[ii][jj] = Integer.parseInt(s.substring(jj, jj+1));
            }
        }
        return map;
    }

    public MapEditor() throws IOException {
        int[][] map = readMapFromString();
        JPanel p = new JPanel(new GridLayout(map.length, map[0].length,0,0));
        p.setBorder(new LineBorder(Color.RED));
        BufferedImage wallImage = 
                new BufferedImage(40, 40, BufferedImage.TYPE_INT_RGB);
        BufferedImage passageImage = 
                new BufferedImage(40, 40, BufferedImage.TYPE_INT_ARGB);
        ImageIcon wallIcon = new ImageIcon(wallImage);
        ImageIcon passageIcon = new ImageIcon(passageImage);
        for (int ii=0; ii<map.length; ii++) {
            for (int jj=0; jj<map[0].length; jj++) {
                int i = map[ii][jj];
                JLabel l = new JLabel();
                if (i==0) {
                    l.setIcon(passageIcon);
                } else {
                    l.setIcon(wallIcon);
                }
                p.add(l);
            }
        }
        JOptionPane.showMessageDialog(null, p);
    }

    public static void main(String[] args) throws IOException {
        MapEditor mp = new MapEditor();
    }
}