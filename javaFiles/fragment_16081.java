package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


public class HtmlLogComponent extends JPanel {
    protected DefaultListModel model = new DefaultListModel();
    protected JList list;
    public static int maxLen = 110;

    public HtmlLogComponent(int maxLen) {
        super(new GridBagLayout());
        this.maxLen = maxLen;

        list = new JList(model);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        list.setSelectionModel(new DisabledItemSelectionModel());

        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);

    }

    public void setEntry(String entry) {
        SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
        Date d = new Date();
        Integer lenght = entry.length();
        String string = "<html>[" + s.format(d) + "] ";
        String substring = entry;

        if (lenght >= maxLen) { // Linebreak needed
            while (lenght >= maxLen) {              
                for (int i=maxLen - 1; i> 0; i--) {
                    if (substring.charAt(i) == ' ') {
                        string += substring.substring(0, i) + "</html>";
                        model.addElement(string);
                        substring = substring.substring(i, lenght);
                        System.out.println(substring);
                        break;
                    }
                }
            lenght = substring.length();
            string = "<html>";          
            }
            model.addElement("<html>" + substring  + "</html>");
        } else {
            model.addElement("<html>[" + s.format(d) + "] " + entry + "</html>");
        }

        int lastIndex = list.getModel().getSize() - 1;
        if (lastIndex >= 0) list.ensureIndexIsVisible(lastIndex);
    }

    class DisabledItemSelectionModel extends DefaultListSelectionModel {

        @Override
        public void setSelectionInterval(int index0, int index1) {
            super.setSelectionInterval(-1, -1);
        }
    }

}