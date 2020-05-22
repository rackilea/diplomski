package app;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
public class PseudofileIconRenderer extends DefaultListCellRenderer {

    private static HashMap<String, Icon> extIcons = new HashMap<String, Icon>();
    private static Pattern p = Pattern.compile("\\.\\w+$");
    private static JFileChooser chooser = new JFileChooser();

    @Override
    public Component getListCellRendererComponent(
        JList list, Object value, int index,
        boolean isSelected, boolean cellHasFocus) {


    JLabel label =
            (JLabel) super.getListCellRendererComponent(list,
            value, index, isSelected, cellHasFocus);


    String filename = (String) value;
    Matcher m = p.matcher(filename);
    Icon i;
    String extension = m.find() ? m.group() : "";
    if (extIcons.containsKey(extension)) {
        i = extIcons.get(extension);
    } else  {
        File file;
        try {
            file = File.createTempFile("icon", extension);
            file.deleteOnExit();

            i = chooser.getIcon(file);
            extIcons.put(extension, i);

        } catch (IOException ex) {
            //this shouldn't happen anyway
            i = null;
        }
    }

    label.setIcon(i);

    return label;
}