import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class Ex extends JFrame {

    private static Map<String, ImageIcon> imageMap;
    private static JScrollPane scrollPane;
    private Color color_bg_azul = new Color(3, 109, 175);
    private Color color_bg_oops = new Color(154, 210, 232);
    private final Font f =  new Font("Tahoma", Font.PLAIN, 18);

    public static void main(String[] args) {
        new Ex();
    }

    @SuppressWarnings({ "unchecked", "serial" })
    public Ex() {
        Container c = getContentPane();

        ArrayList<String> nameList = new ArrayList<String>();
        nameList.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor");
        nameList.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do r");
        nameList.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit eiusmod tempor");
        nameList.add("Lorem ipsum dolor sit amet, consectetur do eiusmod tempor");
        nameList.add("Lorem dolor sit amet, consectetur do eiusmod tempor");

        imageMap = createImageMap(nameList);
        String[] a =  new String[nameList.size()];
        JList list = new JList(nameList.toArray(a)) {
            @Override
            public boolean getScrollableTracksViewportWidth() {
                return true;
            }
        };

        list.setBackground(color_bg_oops);
        list.setCellRenderer(new ImgListRenderer());

        ComponentListener l = new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                list.setFixedCellHeight(10);
                list.setFixedCellHeight(-1);
            }

        };
        list.addComponentListener(l);

        scrollPane = new JScrollPane();
        scrollPane.setViewportView(list);
        c.add(scrollPane);
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private Map<String, ImageIcon> createImageMap(ArrayList<String> list) {
        Map<String, ImageIcon> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            int aux = i+1;
            map.put(list.get(i), new ImageIcon(
                    getClass().getResource("/imgs/" + "icon-06-item-"+aux+ ".png")));
        }
        return map;
    }

    public class ImgListRenderer extends DefaultListCellRenderer {
        private JPanel p;
        private JPanel iconPanel;
        private JLabel lbl_icon;
        private JTextArea ta;

        public ImgListRenderer() {
            p = new JPanel();
            p.setLayout(new BorderLayout());

            // icon
            iconPanel = new JPanel(new BorderLayout());
            iconPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
            iconPanel.setBackground(color_bg_oops);
            lbl_icon = new JLabel(); // <-- this will be an icon instead of a
            // text
            iconPanel.add(lbl_icon, BorderLayout.EAST);
            p.add(iconPanel, BorderLayout.WEST);

            // text
            ta = new JTextArea();
            ta.setLineWrap(true);
            ta.setFont(f);
            ta.setWrapStyleWord(true);
            ta.setBackground(color_bg_oops);
            ta.setForeground(color_bg_azul);
            p.add(ta, BorderLayout.CENTER);
        }

        @SuppressWarnings("rawtypes")
        @Override
        public Component getListCellRendererComponent(final JList list,
                final Object value, final int index, final boolean isSelected,
                final boolean hasFocus) {

            lbl_icon.setIcon(imageMap.get((String) value));
            ta.setText((String) value);
            int width = list.getWidth();
            if (width > 0)
                ta.setSize(width, Short.MAX_VALUE);
            return p;

        }
    }
}